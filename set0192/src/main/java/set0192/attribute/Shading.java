package set0192.attribute;

public enum Shading {
	SOLID(1), STRIPED(2), OUTLINED(3);
	private Integer value;

	private Shading(Integer value) {
		this.value = value;
	}

	public String getValue() {
		return value.toString();
	};
}
