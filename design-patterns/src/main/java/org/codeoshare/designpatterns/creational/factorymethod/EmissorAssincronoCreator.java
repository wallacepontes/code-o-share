package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorAssincronoCreator extends EmissorCreator {
    public Emissor create(int tipoDeEmissor) {
    	if (tipoDeEmissor == EmissorCreator.SMS) {
    		return new EmissorAssincronoSMS();
    	} else if (tipoDeEmissor == EmissorCreator.EMAIL) {
			return new EmissorAssincronoEMAIL();
		} else if (tipoDeEmissor == EmissorCreator.JMS) {
			return new EmissorAssincronoJMS();
		} else {
			throw new IllegalArgumentException("Tipo de emissor não suportado");
		}
    }
}
