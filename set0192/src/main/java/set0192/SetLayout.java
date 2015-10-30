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
import oop.sticks.Layout;
import oop.utils.Console;

public class SetLayout extends Layout {
	private final SetCard[][] predeterminedLayout = {
			{ new SetCard(2, SQUIGGLE, GREEN, OUTLINED),
					new SetCard(1, DIAMOND, PURPLE, SOLID),
					new SetCard(2, OVAL, GREEN, OUTLINED),
					new SetCard(3, OVAL, RED, STRIPED) },
			{ new SetCard(1, DIAMOND, PURPLE, OUTLINED),
					new SetCard(1, SQUIGGLE, PURPLE, OUTLINED),
					new SetCard(3, SQUIGGLE, PURPLE, SOLID),
					new SetCard(2, SQUIGGLE, GREEN, SOLID) },
			{ new SetCard(1, OVAL, GREEN, STRIPED),
					new SetCard(1, SQUIGGLE, RED, SOLID),
					new SetCard(1, OVAL, PURPLE, OUTLINED),
					new SetCard(2, SQUIGGLE, PURPLE, STRIPED) } };

	@Override
	public void display() {
		for (final SetCard[] row : predeterminedLayout) {
			for (final SetCard card : row) {
				Console.printPrompt(card.getEncoded());
			}
			System.out.print("\n");
		}
	}

	public SetCard getCard(Integer index) {
		return predeterminedLayout[index / 4][index % 4];
	}
}
