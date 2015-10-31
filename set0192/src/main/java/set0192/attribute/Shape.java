package set0192.attribute;

/** Shape on the cards */
public enum Shape {
	OVAL(1), SQUIGGLE(2), DIAMOND(3);
	/** value represents the shape */
	private Integer value;

	private Shape(final Integer value) {
		setValue(value);
	}

	private void setValue(final Integer value) {
		this.value = value;
	}

	/** @return the representation of the shape */
	public String getValue() {
		return value.toString();
	}
}
