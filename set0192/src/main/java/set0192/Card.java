package set0192;

import set0192.attribute.Colour;
import set0192.attribute.Shading;
import set0192.attribute.Shape;

/** Class representing cards in set game */
public class Card {
	/** colour of the figures on the card */
	private Colour colour;
	/** shape of the figures on the card */
	private Shape shape;
	/** number of the figures on the card */
	private Integer number;
	/** shading of the figures on the card */
	private Shading shading;

	/**
	 * this is pretty much an immutable representation of set cards because it
	 * fits considering the real world cards
	 */
	public Card(final Integer number, final Shape shape, final Colour colour,
			final Shading shading) {
		setNumber(number);
		setShape(shape);
		setColour(colour);
		setShading(shading);
	}

	/**
	 * gets the encoded string representation according to the project
	 * documentation
	 */
	public String getEncoded() {
		return colour.getValue() + shape.getValue() + number
				+ shading.getValue();
	}

	private Card setColour(final Colour colour) {
		if (getColour() == null) {
			this.colour = colour;
		} else {
			throw new ImmutableAttributeException(colour);
		}
		return this;
	}

	private Card setShape(final Shape shape) {
		if (getShape() == null) {
			this.shape = shape;
		} else {
			throw new ImmutableAttributeException(shape);
		}
		return this;
	}

	private Card setNumber(final Integer number) {
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

	private Card setShading(final Shading shading) {
		if (getShading() == null) {
			this.shading = shading;
		} else {
			throw new ImmutableAttributeException(shading);
		}
		return this;
	}

	/** @return colour of the figures on the card */
	public Colour getColour() {
		return colour;
	}

	/** @return shape of the figures on the card */
	public Shape getShape() {
		return shape;
	}

	/** @return number of the figures on the card */
	public Integer getNumber() {
		return number;
	}

	/** @return shading of the figures on the card */
	public Shading getShading() {
		return shading;
	}
}
