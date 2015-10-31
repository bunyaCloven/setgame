package set0192.attribute;

/** Colour of the shapes on the card */
public enum Colour {
	RED(1), PURPLE(2), GREEN(3);
	/** integer representation of the shape */
	private Integer value;

	private Colour(final Integer value) {
		setValue(value);
	}

	private void setValue(final Integer value) {
		this.value = value;
	}

	/** @return the integer representation of the shape */
	public String getValue() {
		return value.toString();
	}
}
