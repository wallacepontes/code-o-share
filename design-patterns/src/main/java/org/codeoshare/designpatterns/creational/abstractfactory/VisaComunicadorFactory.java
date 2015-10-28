package org.codeoshare.designpatterns.creational.abstractfactory;

import org.codeoshare.designpatterns.creational.factorymethod.Emissor;
import org.codeoshare.designpatterns.creational.factorymethod.EmissorCreator;

public class VisaComunicadorFactory implements ComunicadorFactory {
    private EmissorCreator emissorCreator = new EmissorCreator();
    private ReceptorCreator receptorCreator = new ReceptorCreator();

	public Emissor createEmissor() {
		return emissorCreator.create(EmissorCreator.VISA);
	}

	public Receptor createReceptor() {
		return receptorCreator.create(ReceptorCreator.VISA);
	}
}
