package retail.core.domain;

/**
 * @author Loic Talhouarne
 * 
 *         Featured constants.
 *
 */
public enum Feature {
	YES("Y"), NO("N");

	private final String featured;

	private Feature(String featured) {
		this.featured = featured;
	}

	public String getFeatured() {
		return featured;
	}

	@Override
	public String toString() {
		return featured;
	}
}
