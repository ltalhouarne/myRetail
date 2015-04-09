package retail.core.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Loic Talhouarne
 *
 *         Custom annotation for Featured validation.
 *         
 */
@Constraint(validatedBy = FeaturedValidator.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Featured {
	String message() default "Featured can only be 'Y/N'";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
