package set0192;

/** move that players make in their turns */
public class Move {
	/** card 1/3 of the selection */
	private final String card0;
	/** card 2/3 of the selection */
	private final String card1;
	/** card 3/3 of the selection */
	private final String card2;

	/** collection of three selected cards */
	public Move(final String input) {
		final String[] cards = input.split(" +");
		this.card0 = cards[0];
		this.card1 = cards[1];
		this.card2 = cards[2];
	}

	/** @return the first selection */
	public String getCard0() {
		return card0;
	}

	/** @return the seconds selection */
	public String getCard1() {
		return card1;
	}

	/** @return the third selection */
	public String getCard2() {
		return card2;
	}

}
