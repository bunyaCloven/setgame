package set0192.attribute;

/** shading of the shape on the cards */
public enum Shading {
	SOLID(1), STRIPED(2), OUTLINED(3);
	/** value which represents the shading */
	private Integer value;

	private Shading(final Integer value) {
		setValue(value);
	}

	private void setValue(final Integer value) {
		this.value = value;
	}

	/** @return the value which represents the shading */
	public String getValue() {
		return value.toString();
	};
}
