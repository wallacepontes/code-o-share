package org.codeoshare.cdi.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class GeradorDeNumeros {
	
	@Named
	@Produces
	@RequestScoped
	public List<Double> getNumeros() {
		System.out.println("Gerando Números");
		List<Double> numeros = new ArrayList<Double>();
		for (int i = 0; i < 5; i++) {
			numeros.add(Math.random());
		}
		return numeros;
	}

}
