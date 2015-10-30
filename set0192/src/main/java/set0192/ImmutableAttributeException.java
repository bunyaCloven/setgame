package set0192;

/** thrown when something that is not supposed to be changed is about to change */
public class ImmutableAttributeException extends RuntimeException {
	/***/
	private static final long serialVersionUID = 8607944318604160997L;

	/** Tells what is the target attribute */
	public ImmutableAttributeException(final Enum<?> enumeration) {
		super(enumeration.name());
	}

	/** Tells what is the target attribute */
	public ImmutableAttributeException(final Integer number) {
		super(number.toString());
	}

}
