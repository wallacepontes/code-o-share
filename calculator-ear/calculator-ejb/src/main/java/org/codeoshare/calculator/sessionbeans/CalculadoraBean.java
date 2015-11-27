package org.codeoshare.calculator.sessionbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.codeoshare.calculator.sessionbeans.Calculadora;

@Stateless
@Local(Calculadora.class)
public class CalculadoraBean implements Calculadora {

	@PostConstruct
	public void inicializando() {
		System.out.println("Mais uma calculadora criada...");
	}

	@PreDestroy
	public void destruindo() {
		System.out.println("Mais uma calculadora será destruída...");
	}

	@Override
	public double soma(double a, double b) {
		return a + b;
	}

	@Override
	public double subtrai(double a, double b) {
		return a - b;
	}

	@Override
	public double multiplica(double a, double b) {
		return a*b;
	}

	@Override
	public double divide(double a, double b) {
		return a/b;
	}

}
