package set0192;

import oop.sticks.SaveGameException;

/** Main class. Contains {@link #main(String[])} which starts the game */
@SuppressWarnings("PMD.UseUtilityClass")
public class SetGame {
	/** the start of the program. takes no arguments */
	@SuppressWarnings("PMD.UseVarargs")
	public static void main(final String[] args) throws SaveGameException {
		final SetReferee referee = new SetReferee();
		referee.startGame(2);
	}
}
