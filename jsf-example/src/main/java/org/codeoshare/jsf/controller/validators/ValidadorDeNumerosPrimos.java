package org.codeoshare.jsf.controller.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("org.codeoshare.jsf.controller.validators.ValidadorDeNumerosPrimos")
public class ValidadorDeNumerosPrimos implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		long numero = (Long) value;
		boolean isPrimo = false;

		if (numero>1) {
			double raizQuadrada = Math.sqrt((double)numero);
			isPrimo=true;

			for (int i = 2; i <= raizQuadrada; i++) {
				if(numero % i == 0) {
					isPrimo = false;
					break;
				}
			}
		}
		if (!isPrimo) {
			FacesMessage message = new FacesMessage("O número " + numero + " não é primo");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}



}
