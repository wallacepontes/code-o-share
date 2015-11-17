package org.codeoshare.jsf.controller.beanvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.codeoshare.jsf.model.entities.CPF;

public class CPFBeanValidator implements ConstraintValidator< org.codeoshare.jsf.controller.beanvalidators.CPF, org.codeoshare.jsf.model.entities.CPF> {

	@Override
	public void initialize(org.codeoshare.jsf.controller.beanvalidators.CPF constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(org.codeoshare.jsf.model.entities.CPF value, ConstraintValidatorContext context) {
		org.codeoshare.jsf.model.entities.CPF cpf = (org.codeoshare.jsf.model.entities.CPF) value;
		int numeroDeIdentificacao = cpf.getNumeroDeIdentificacao();
		int primeiroDigitoVerificador = cpf.getPrimeiroDigitoVerificador();
		int segundoDigitoVerificador = cpf.getSegundoDigitoVerificador();

		return this.validaCPF(numeroDeIdentificacao, primeiroDigitoVerificador, segundoDigitoVerificador);
	}

	private boolean validaCPF(int numeroDeIdentificacao, int primeiroDigitoVerificador, int segundoDigitoVerificador) {
		long primeiroDigito = this.modulo11((long)numeroDeIdentificacao);
		long segundoDigito = this.modulo11((long) numeroDeIdentificacao * 10 + primeiroDigito);

		return primeiroDigitoVerificador == primeiroDigito && segundoDigitoVerificador == segundoDigito;
	}

	private long modulo11(long numero) {
		long soma=0;
		long multiplicador = 2;
		while(numero >0) {
			long  digito=numero % 10;
			soma += multiplicador * digito;
			numero /= 10;
			multiplicador++;
		}
		long resto = soma % 11;
		if (resto < 2) {
			return 0;
		} else {
			return 11 - resto;
		}
	}
}
