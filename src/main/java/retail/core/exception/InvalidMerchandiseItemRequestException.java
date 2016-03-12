package retail.core.exception;

import org.springframework.validation.Errors;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Exception to be thrown when a web request's arguments are invalid.
 */
public class InvalidMerchandiseItemRequestException extends RuntimeException {
    private static final long serialVersionUID = -6299314630526733277L;
    private Errors errors;

    public InvalidMerchandiseItemRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
