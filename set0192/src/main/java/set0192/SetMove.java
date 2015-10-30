package set0192;

public class SetMove {
	private String[] cards;

	public SetMove(String... cards) {
		this.cards = new String[] { cards[0], cards[1], cards[2] };
	}

	public String[] getCards() {
		return cards;
	}
}
