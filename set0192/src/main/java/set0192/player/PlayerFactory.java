package set0192.player;

import java.util.concurrent.atomic.AtomicLong;

/** Factory class for {@link Player} */
public class PlayerFactory {
	/** id of the next player */
	private transient final AtomicLong identifier;

	/** returns a new factory */
	public PlayerFactory() {
		identifier = new AtomicLong(1L);
	}

	/** @return a new player */
	public Player newPlayer() {
		final Player result = new Player();
		result.setIdentifier(identifier.getAndIncrement());
		result.determineName();
		return result;
	}
}
