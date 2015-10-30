package set0192;

import java.math.BigInteger;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import set0192.player.PlayerFactory;
import set0192.player.SetPlayer;

/** mediator of set game */
public class SetReferee {
	/** queue that holds the players in the order that they will play */
	private transient boolean gameOver;
	private transient final Queue<SetPlayer> turnQueue;
	private transient SetLayout layout;
	private transient final Map<SetPlayer, BigInteger> scoreboard;

	/** no-arg constructor */
	public SetReferee() {
		this.turnQueue = new LinkedBlockingQueue<>();
		this.layout = new SetLayout();
		this.gameOver = false;
		this.scoreboard = new WeakHashMap<>();
	}

	/** starts the game */
	public void startGame(final Integer playerCount) {
		final PlayerFactory playerFactory = new PlayerFactory();
		for (int i = 0; i < playerCount; i++) {
			final SetPlayer player = playerFactory.newPlayer();
			turnQueue.offer(player);
			scoreboard.put(player, BigInteger.ZERO);
		}
		do {
			layout.display();
			SetPlayer player = turnQueue.poll();
			SetMove move = player.makeMove();
			if (isSet(move)) {
				scoreboard.put(player,
						scoreboard.get(player).add(BigInteger.ONE));
				System.out.println(scoreboard.get(player).intValue());
				if (scoreboard.get(player).intValue() > 3) {
					gameOver = true;
				}
			}
			turnQueue.offer(player);
		} while (!gameOver);
	}

	public boolean isSet(final SetMove move) {
		for (int i = 0; i < 4; i++) {
			final Character char0 = getByte(getCard(move.get0()), i);
			final Character char1 = getByte(getCard(move.get1()), i);
			final Character char2 = getByte(getCard(move.get2()), i);
			if (!isAllSame(char0, char1, char2)
					&& !isAllDifferent(char0, char1, char2)) {
				System.out.println("meh");
				return false;
			}
		}
		System.out.println("whoa");
		return true;
	}

	private boolean isAllSame(final Character char0, final Character char1,
			final Character char2) {
		return char0.equals(char1) && char1.equals(char2);
	}

	private boolean isAllDifferent(final Character char0,
			final Character char1, final Character char2) {
		return !char0.equals(char1) && !char1.equals(char2)
				&& !char0.equals(char2);
	}

	public SetCard getCard(final Integer index) {
		return layout.getCard(index);
	}

	public SetCard getCard(final String index) {
		return getCard(Integer.valueOf(index));
	}

	public Character getByte(SetCard card, Integer i) {
		return card.getEncoded().charAt(i);
	}
}
