package retail.core.validation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Represents a returnable resource to a web request for Global errors
 *         that holds a code and a message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorGlobal {
    private String code;
    private String message;

    public ErrorGlobal() {

    }

    public ErrorGlobal(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
