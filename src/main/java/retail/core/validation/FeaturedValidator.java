package retail.core.validation;

import retail.core.domain.Feature;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Custom validator for {@code String} representing Featured
 *         merchandise.
 */
public class FeaturedValidator implements ConstraintValidator<Featured, String> {

    @Override
    public void initialize(Featured constraintAnnotation) {
    }

    @Override
    public boolean isValid(String featured, ConstraintValidatorContext context) {
        if (featured == null || featured.isEmpty()) {
            return false;
        }

        for (Feature feat : Feature.values()) {
            if (feat.toString().equals(featured)) {
                return true;
            }
        }

        return false;
    }

}
