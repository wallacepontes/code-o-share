package org.codeoshare.designpatterns.creational.abstractfactory;

import org.codeoshare.designpatterns.creational.abstractfactory.EmissorMASTERCARD;
import org.codeoshare.designpatterns.creational.abstractfactory.EmissorVISA;

public class EmissorCreator {
	public static final int VISA = 1;
	public static final int MASTERCARD = 2;
	
	public Emissor create(int tipoDeEmissor) {
		if (tipoDeEmissor == EmissorCreator.VISA) {
			return new EmissorVISA();
		} else if (tipoDeEmissor == EmissorCreator.MASTERCARD) {
			return new EmissorMASTERCARD();
		} else {
			throw new IllegalArgumentException("Tipo de Emissor nao suportado");
		}
	}
}
