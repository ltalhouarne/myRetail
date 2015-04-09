package retail.core.domain;

/**
 * @author Loic Talhouarne
 * 
 *         Availability constants.
 *
 */
public enum Availability {
	AVAILABLE("available"), UNAVAILABLE("unavailable");

	private final String availability;

	private Availability(String availability) {
		this.availability = availability;
	}

	public String getAvailability() {
		return availability;
	}

	@Override
	public String toString() {
		return availability;
	}
}
