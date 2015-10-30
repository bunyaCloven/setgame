package set0192;

import set0192.attribute.Colour;
import set0192.attribute.Shading;
import set0192.attribute.Shape;

public class SetCard {

	private Colour colour;
	private Shape shape;
	private Integer number;
	private Shading shading;

	/**
	 * gets the encoded string representation according to the project
	 * documentation
	 */
	public String getEncoded() {
		return colour.getValue() + shape.getValue() + number
				+ shading.getValue();
	}

	private SetCard setColour(final Colour colour) {
		if (getColour() == null) {
			this.colour = colour;
		} else {
			throw new ImmutableAttributeException(colour);
		}
		return this;
	}

	private SetCard setShape(final Shape shape) {
		if (getShape() == null) {
			this.shape = shape;
		} else {
			throw new ImmutableAttributeException(shape);
		}
		return this;
	}

	private SetCard setNumber(final Integer number) {
		if (getNumber() == null) {
			if (number > 0 && number < 4) {
				this.number = number;
			} else {
				throw new IndexOutOfBoundsException(number.toString());
			}
		} else {
			throw new ImmutableAttributeException(number);
		}
		return this;
	}

	private SetCard setShading(final Shading shading) {
		if (getShading() == null) {
			this.shading = shading;
		} else {
			throw new ImmutableAttributeException(shading);
		}
		return this;
	}

	public SetCard red() {
		return setColour(Colour.RED);
	}

	public SetCard purple() {
		return setColour(Colour.PURPLE);
	}

	public SetCard green() {
		return setColour(Colour.GREEN);
	}

	public SetCard oval() {
		return setShape(Shape.OVAL);
	}

	public SetCard squiggle() {
		return setShape(Shape.SQUIGGLE);
	}

	public SetCard diamond() {
		return setShape(Shape.DIAMOND);
	}

	public SetCard one() {
		return setNumber(1);
	}

	public SetCard two() {
		return setNumber(2);
	}

	public SetCard three() {
		return setNumber(3);
	}

	public SetCard solid() {
		return setShading(Shading.SOLID);
	}

	public SetCard striped() {
		return setShading(Shading.STRIPED);
	}

	public SetCard outlined() {
		return setShading(Shading.OUTLINED);
	}

	public Colour getColour() {
		return colour;
	}

	public Shape getShape() {
		return shape;
	}

	public Integer getNumber() {
		return number;
	}

	public Shading getShading() {
		return shading;
	}
}
