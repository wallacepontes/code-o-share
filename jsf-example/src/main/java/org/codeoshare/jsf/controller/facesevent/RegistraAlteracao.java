package org.codeoshare.jsf.controller.facesevent;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class RegistraAlteracao implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent e) throws AbortProcessingException {
		System.out.println("Preço antigo:" + e.getOldValue());
		System.out.println("Preço novo:" + e.getNewValue());
	}
}