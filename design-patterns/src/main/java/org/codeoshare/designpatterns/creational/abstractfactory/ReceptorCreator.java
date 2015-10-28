package org.codeoshare.designpatterns.creational.abstractfactory;

public class ReceptorCreator {
	public static final int VISA = 1;
	public static final int MASTERCARD = 2;
	
	public Receptor create(int tipoDeReceptor) {
		if (tipoDeReceptor == ReceptorCreator.VISA) {
			return new ReceptorVISA();
		} else if (tipoDeReceptor == ReceptorCreator.MASTERCARD) {
			return new ReceptorMASTERCARD();
		} else {
			throw new IllegalArgumentException("Tipo de Receptor nao suportado");
		}
	}
}
