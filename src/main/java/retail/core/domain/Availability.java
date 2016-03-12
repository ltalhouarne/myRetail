package retail.core.domain;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Availability constants.
 */
public enum Availability {
    AVAILABLE("available"), UNAVAILABLE("unavailable");

    private final String availability;

    Availability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return availability;
    }
}
