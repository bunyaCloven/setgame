package set0192.attribute;

public enum Shape {
	OVAL(1), SQUIGGLE(2), DIAMOND(3);
	private Integer value;

	private Shape(Integer value) {
		this.value = value;
	}

	public String getValue() {
		return value.toString();
	}
}
