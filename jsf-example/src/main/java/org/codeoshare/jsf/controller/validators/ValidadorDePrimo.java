package org.codeoshare.jsf.controller.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.codeoshare.jsf.controller.beanvalidators.Primo;

public class ValidadorDePrimo implements ConstraintValidator<Primo, Long> {

	@Override
	public void initialize(Primo constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if (value <= 1) {
			return false;
		}
		double raizQuadrada = Math.sqrt((double) value);
		
		for (long i = 2; i < raizQuadrada; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
}
