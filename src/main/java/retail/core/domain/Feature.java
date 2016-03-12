package retail.core.domain;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Featured constants.
 */
public enum Feature {
    YES("Y"), NO("N");

    private final String featured;

    Feature(String featured) {
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
