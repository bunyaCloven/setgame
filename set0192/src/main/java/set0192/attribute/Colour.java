package set0192.attribute;

public enum Colour {
	RED(1), PURPLE(2), GREEN(3);
	private Integer value;

	private Colour(Integer value) {
		this.value = value;
	}

	public String getValue() {
		return value.toString();
	}
}
