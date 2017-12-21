package self.learning.spring_web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

	private int min;
	
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		min = constraintAnnotation.min();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.length() < min) return false;
		if (!value.contains("@")) return false;
		if (!value.contains(".")) return false;
		return true;
	}

}
