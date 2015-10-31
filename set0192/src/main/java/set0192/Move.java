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
		System.out.println("input: " + input);
		final String[] cards = input.split(" +");
		System.out.println("split: " + cards);
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

	@Override
	@SuppressWarnings("PMD")
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card0 == null) ? 0 : card0.hashCode());
		result = prime * result + ((card1 == null) ? 0 : card1.hashCode());
		result = prime * result + ((card2 == null) ? 0 : card2.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("PMD")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (card0 == null) {
			if (other.card0 != null)
				return false;
		} else if (!card0.equals(other.card0))
			return false;
		if (card1 == null) {
			if (other.card1 != null)
				return false;
		} else if (!card1.equals(other.card1))
			return false;
		if (card2 == null) {
			if (other.card2 != null)
				return false;
		} else if (!card2.equals(other.card2))
			return false;
		return true;
	}

}
