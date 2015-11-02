package set0192.player;

import java.io.Serializable;

import oop.minimax.Score;

/** Players who will play the Set Game */
public class Player implements Serializable {
	/***/
	private static final long serialVersionUID = -2333328308151401928L;
	/** name of the player */
	private String name;
	/** score of the player */
	private final Score score;

	/** a brand new player */
	public Player(final String name) {
		setName(name);
		score = new Score();
		score.setScore(0);
	}

	/** @return the name of the player */
	public String getName() {
		return name;
	}

	/** sets the name of the player */
	public void setName(final String name) {
		this.name = name;
	}

	/** @return the score of the player */
	public Integer getScore() {
		return score.getScore();
	}

	/** increases score by 1 */
	public void incrementScore() {
		score.setScore(score.getScore() + 1);
	}
}
