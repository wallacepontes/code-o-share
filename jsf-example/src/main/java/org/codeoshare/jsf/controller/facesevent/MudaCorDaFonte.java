package org.codeoshare.jsf.controller.facesevent;

import javax.faces.component.UICommand;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class MudaCorDaFonte implements ActionListener {

	@Override
	public void processAction(ActionEvent e) throws AbortProcessingException {
		UICommand c = (UICommand) e.getComponent();
		
		c.getAttributes().put("style", "color: red;");

	}

}
