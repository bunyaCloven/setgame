package set0192.player;

import oop.utils.Console;
import set0192.Identifiable;
import set0192.SetLayout;
import set0192.SetMove;

public class SetPlayer implements Identifiable {
	private String name;
	private Long identifier;

	protected final void determineName() {
		setName(Console.readLine("Player #" + identifier
				+ " , please enter your name: "));
	}

	public SetMove makeMove() {
		String moveInput = Console.readLine("Please choose cards: ");
		String[] cards = moveInput.split(" +");
		return new SetMove(cards[0], cards[1], cards[2]);
	}

	public void setId(final Long identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
