package retail.core.validation;

import retail.core.domain.Availability;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Custom validator for {@code String} representing availability.
 */
public class AvailableValidator implements ConstraintValidator<Available, String> {

    @Override
    public void initialize(Available constraintAnnotation) {
    }

    @Override
    public boolean isValid(String available, ConstraintValidatorContext context) {
        if (available == null || available.isEmpty()) {
            return false;
        }

        for (Availability avail : Availability.values()) {
            if (avail.toString().equals(available)) {
                return true;
            }
        }

        return false;
    }

}
