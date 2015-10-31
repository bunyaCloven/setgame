package set0192;


/** Main class. Contains {@link #main(String[])} which starts the game */
@SuppressWarnings("PMD.UseUtilityClass")
public class SetGame {
	/** the start of the program. takes no arguments */
	@SuppressWarnings("PMD.UseVarargs")
	public static void main(final String[] args) {
		final Referee referee = new Referee();
		referee.startGame(2);
	}
}
