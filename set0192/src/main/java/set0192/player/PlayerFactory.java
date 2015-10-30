package set0192.player;

import java.util.concurrent.atomic.AtomicLong;

/** Factory class for {@link SetPlayer} */
public class PlayerFactory {
	/** id of the next player */
	private transient final AtomicLong identifier;

	/** returns a new factory */
	public PlayerFactory() {
		identifier = new AtomicLong(1L);
	}

	/** @return a new player */
	public SetPlayer newPlayer() {
		final SetPlayer result = new SetPlayer();
		result.setId(identifier.getAndIncrement());
		result.determineName();
		return result;
	}
}
