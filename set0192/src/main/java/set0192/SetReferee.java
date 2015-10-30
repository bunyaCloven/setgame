package set0192;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import set0192.player.SetPlayer;

/** mediator of set game */
public class SetReferee {
	/** queue that holds the players in the order that they will play */
	private transient final Queue<SetPlayer> turnQueue;
	private transient SetLayout layout;

	/** no-arg constructor */
	public SetReferee() {
		turnQueue = new LinkedBlockingQueue<>();
	}

	/** starts the game */
	public void startGame(final SetPlayer[] players, final SetLayout layout) {
		this.layout = layout;
		for (final SetPlayer player : players) {
			turnQueue.offer(player);
		}
		do {
			layout.display();
			SetPlayer player = turnQueue.poll();
			SetMove move = player.makeMove();
			if (isSet(move)) {
				System.out.println("you got it!");
			}
		} while (false);
	}

	private boolean isSet(SetMove move) {
		String[] cards = move.getCards();
		String card0 = layout.getCard(Integer.valueOf(cards[0])).getEncoded();
		String card1 = layout.getCard(Integer.valueOf(cards[1])).getEncoded();
		String card2 = layout.getCard(Integer.valueOf(cards[2])).getEncoded();
		for (int i = 0; i < 4; i++) {
			final Character char0 = card0.charAt(i);
			final Character char1 = card1.charAt(i);
			final Character char2 = card2.charAt(i);
			if (!isAllSame(char0, char1, char2)
					&& !isAllDifferent(char0, char1, char2)) {
				System.out.println("meh");
				System.out.println(card0 + " " + card1 + " " + card2);
				return false;
			}
		}
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

	// private getCards() {
	//
	// }
	// public List<String> getCardsEncoded(final SetCard... cards) {
	// final LinkedList<String> result = new LinkedList<>();
	// for (final SetCard card : cards) {
	// result.add(card.getEncoded());
	// }
	// return result;
	// }
}
