package set0192;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import oop.utils.Console;
import set0192.player.Player;
import set0192.player.PlayerFactory;

/** mediator of set game */
public class Referee {
	/** list of previously done moves */
	private transient final List<Move> moves;
	/** the score a player should reach to win */
	private transient Integer winningScore;
	/** flag that tells if the game is over */
	private transient boolean gameOver;
	/** queue that holds the players in the order that they will play */
	private transient final Queue<Player> turnQueue;
	/** the layout of the game */
	private transient final Layout layout;

	/** no-arg constructor */
	public Referee() {
		this.turnQueue = new LinkedBlockingQueue<>();
		this.layout = new Layout();
		this.moves = new LinkedList<>();
		this.gameOver = false;
	}

	/** starts the game */
	public void startGame(final Integer playerCount) {
		final PlayerFactory playerFactory = new PlayerFactory();
		for (int i = 0; i < playerCount; i++) {
			@SuppressWarnings("PMD.LawOfDemeter")
			final Player player = playerFactory.newPlayer();
			turnQueue.offer(player);
		}
		do {
			layout.display();
			final Player player = turnQueue.poll();
			final Move move = makeMoveAs(player);
			if (isValidMove(move) && !moves.contains(move)) {
				System.out.println("You have found a set!");
				// FIXME: demeter cries in horror
				moves.add(move);
				player.incrementScore();
				if (getScore(player) > getWinningScore()) {
					gameOver = true;
				}
			}
			turnQueue.offer(player);
		} while (!gameOver);
		System.out.print("Game is over!");
		announceWinner();
	}

	// FIXME: shouldn't be there, make a synchronizing datasource instead
	private Boolean didPrompt = false;

	@SuppressWarnings("PMD.DoNotUseThreads")
	/** @return the move the player made */
	public Move makeMoveAs(final Player player) {
		System.out
				.println(getName(player)
						+ ", it's your turn. Please enter 's' in 10 seconds to enter a set");
		Move result = null;
		final Thread thread = new Thread(() -> {
			while (true) {
				didPrompt = "s".equals(Console.readLine().trim()
						.toLowerCase(Locale.ENGLISH));
				if (didPrompt) {
					break;
				}
			}
		});
		thread.start();
		for (int i = 0; i < 1000; i++) {
			try {
				synchronized (this) {
					if (didPrompt) {
						break;
					}
					Thread.sleep(10);
				}
			} catch (InterruptedException ignored) {
			}
		}
		thread.interrupt();
		if (didPrompt) {
			result = new Move(Console.readLine(getName(player)
					+ ", please choose cards: "));
		} else {
			System.out.println("You couldn't find any sets in given time");
		}
		return result;
	}

	private void announceWinner() {
		Player winner = null;
		Integer highscore = -1;
		for (final Player player : turnQueue) {
			final Integer score = getScore(player);
			if (score > highscore) {
				highscore = score;
				winner = player;
			}
		}
		System.out.println(getName(winner) + " won!");
	}

	private boolean isValidMove(final Move move) {
		return layout.isSet(move.getCard0(), move.getCard1(), move.getCard2());
	}

	/** sets the winning criteria */
	public void setWinningScore(final Integer value) {
		this.winningScore = value;
	}

	/** @return the score that a player must reach to win */
	public Integer getWinningScore() {
		return winningScore;
	}

	/** @return score of the player */
	private Integer getScore(final Player player) {
		return player.getScore();
	}

	private String getName(Player player) {
		return player.getName();
	}
}
