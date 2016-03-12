package retail.core.exception;

import org.springframework.validation.Errors;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Exception to be thrown whenever a merchandise item could not be found.
 */
public class MerchandiseItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -81446776253620815L;
    private Errors errors;

    public MerchandiseItemNotFoundException(String message) {
        super(message);
    }

    public MerchandiseItemNotFoundException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
