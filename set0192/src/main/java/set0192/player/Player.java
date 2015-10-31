package set0192.player;

import oop.utils.Console;
import set0192.Identifiable;
import set0192.Move;

/** Players who will play the Set Game */
public class Player implements Identifiable {
	/** name of the player */
	private String name;
	/** identifier of the player */
	private Long identifier;

	/** prompts the name from the user */
	protected final void determineName() {
		setName(Console.readLine("Player #" + getIdentifier()
				+ " , please enter your name: "));
	}

	/** sets the identifier of the player */
	public void setIdentifier(final Long identifier) {
		this.identifier = identifier;
	}

	/** @return the name of the player */
	public String getName() {
		return name;
	}

	/** sets the name of the player */
	public void setName(final String name) {
		this.name = name;
	}

	/** @return identifier of the user */
	private Long getIdentifier() {
		return identifier;
	}

}
