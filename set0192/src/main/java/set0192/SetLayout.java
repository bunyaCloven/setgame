package set0192;

import oop.sticks.Layout;
import oop.utils.Console;

public class SetLayout extends Layout {
	private final SetCard[][] predeterminedLayout = {
			{ new SetCard().two().squiggle().green().outlined(),
					new SetCard().one().diamond().purple().solid(),
					new SetCard().two().oval().green().outlined(),
					new SetCard().three().oval().red().striped() },
			{ new SetCard().one().diamond().purple().outlined(),
					new SetCard().one().squiggle().purple().outlined(),
					new SetCard().three().squiggle().purple().solid(),
					new SetCard().two().squiggle().green().solid() },
			{ new SetCard().one().oval().green().striped(),
					new SetCard().one().squiggle().red().solid(),
					new SetCard().one().oval().purple().outlined(),
					new SetCard().two().squiggle().purple().striped() } };

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
