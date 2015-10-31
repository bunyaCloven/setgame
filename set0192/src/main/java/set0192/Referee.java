package set0192;

import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import oop.minimax.Score;
import oop.utils.Console;
import set0192.player.Player;
import set0192.player.PlayerFactory;

/** mediator of set game */
public class Referee {
	/** flag that tells if the game is over */
	private transient boolean gameOver;
	/** queue that holds the players in the order that they will play */
	private transient final Queue<Player> turnQueue;
	/** the layout of the game */
	private transient final Layout layout;
	/** the scoreboard of the current game */
	private transient final Map<Player, Score> scoreboard;

	/** no-arg constructor */
	public Referee() {
		this.turnQueue = new LinkedBlockingQueue<>();
		this.layout = new Layout();
		this.gameOver = false;
		this.scoreboard = new WeakHashMap<>();
	}

	/** starts the game */
	public void startGame(final Integer playerCount) {
		final PlayerFactory playerFactory = new PlayerFactory();
		for (int i = 0; i < playerCount; i++) {
			@SuppressWarnings("PMD.LawOfDemeter")
			final Player player = playerFactory.newPlayer();
			turnQueue.offer(player);
			@SuppressWarnings("PMD.AvoidInstantiatingObjectsInLoops")
			final Score score = new Score();
			score.setScore(0);
			scoreboard.put(player, score);
		}
		do {
			layout.display();
			final Player player = turnQueue.poll();
			final Move move = makeMoveAs(player);
			if (layout.isSet(move.getCard0(), move.getCard1(), move.getCard2())) {
				System.out.println("You have found a set!");
				// FIXME: demeter cries in horror
				final Score score = scoreboard.get(player);
				score.setScore(score.getScore() + 1);
				scoreboard.put(player, score);
				if (score.getScore() > 3) {
					gameOver = true;
				}
			}
			turnQueue.offer(player);
		} while (!gameOver);
		System.out.print("Game is over!");
		announceWinner();
	}

	/** @return the move the player made */
	public Move makeMoveAs(Player player) {
		return new Move(Console.readLine(player.getName()
				+ ", please choose cards: "));
	}

	private void announceWinner() {
		Player winner = null;
		Integer highscore = -1;
		for (final Player player : scoreboard.keySet()) {
			final Integer score = scoreboard.get(player).getScore();
			if (score > highscore) {
				highscore = score;
				winner = player;
			}
		}
		System.out.println(winner.getName() + " won!");
	}
}
