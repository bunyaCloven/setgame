package set0192;

import oop.sticks.SaveGameException;
import set0192.player.PlayerFactory;
import set0192.player.SetPlayer;

/** Main class. Contains {@link #main(String[])} which starts the game */
@SuppressWarnings("PMD.UseUtilityClass")
public class SetGame {
	/** the start of the program. takes no arguments */
	@SuppressWarnings("PMD.UseVarargs")
	public static void main(final String[] args) throws SaveGameException {
		final PlayerFactory playerFactory = new PlayerFactory();
		final SetPlayer[] players = { playerFactory.newPlayer(),
				playerFactory.newPlayer() };
		final SetReferee referee = new SetReferee();
		referee.startGame(players, new SetLayout());
	}
}
