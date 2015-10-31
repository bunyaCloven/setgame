package set0192;

import static set0192.attribute.Colour.GREEN;
import static set0192.attribute.Colour.PURPLE;
import static set0192.attribute.Colour.RED;
import static set0192.attribute.Shading.OUTLINED;
import static set0192.attribute.Shading.SOLID;
import static set0192.attribute.Shading.STRIPED;
import static set0192.attribute.Shape.DIAMOND;
import static set0192.attribute.Shape.OVAL;
import static set0192.attribute.Shape.SQUIGGLE;
import oop.utils.Console;

/** Class that represents the layout of the cards */

@SuppressWarnings("PMD.TooManyStaticImports")
// because it makes cards variable cleaner
public class Layout {
	/** predetermined cards in the layout */
	private transient final Card[][] cards = {
			{ new Card(2, SQUIGGLE, GREEN, OUTLINED),
					new Card(1, DIAMOND, PURPLE, SOLID),
					new Card(2, OVAL, GREEN, OUTLINED),
					new Card(3, OVAL, RED, STRIPED) },
			{ new Card(1, DIAMOND, PURPLE, OUTLINED),
					new Card(1, SQUIGGLE, PURPLE, OUTLINED),
					new Card(3, SQUIGGLE, PURPLE, SOLID),
					new Card(2, SQUIGGLE, GREEN, SOLID) },
			{ new Card(1, OVAL, GREEN, STRIPED),
					new Card(1, SQUIGGLE, RED, SOLID),
					new Card(1, OVAL, PURPLE, OUTLINED),
					new Card(2, SQUIGGLE, PURPLE, STRIPED) } };

	/** displays the layout on the console */
	public void display() {
		for (final Card[] row : cards) {
			for (final Card card : row) {
				Console.printPrompt(card.getEncoded());
			}
			System.out.println();
		}
	}

	/** @return a card from the layout, 0 being the card in the top left corner */
	public Card getCard(final Integer index) {
		return cards[index / 4][index % 4];
	}

	/** overloaded method of {@link #getCard(Integer)} */
	public Card getCard(final String index) {
		return getCard(Integer.valueOf(index));
	}

	/** decides if three input cards is a set */
	public boolean isSet(final String card0, final String card1,
			final String card2) {
		Boolean result = true;
		for (int i = 0; i < 4; i++) {
			final Character char0 = getByte(getEncoded(getCard(card0)), i);
			final Character char1 = getByte(getEncoded(getCard(card1)), i);
			final Character char2 = getByte(getEncoded(getCard(card2)), i);
			if (!isAllSame(char0, char1, char2)
					&& !isAllDifferent(char0, char1, char2)) {
				result = false;
				break;
			}
		}
		return result;
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

	/** @return the character */
	public Character getByte(final String target, final Integer index) {
		return target.charAt(index);
	}

	/** @return string representation of the card */
	public String getEncoded(final Card card) {
		return card.getEncoded();
	}
}
