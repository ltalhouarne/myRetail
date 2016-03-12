package retail.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Custom annotation for availability validation.
 */
@Constraint(validatedBy = AvailableValidator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Available {
    String message() default "Availability can only be 'Available/Unavailable'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
