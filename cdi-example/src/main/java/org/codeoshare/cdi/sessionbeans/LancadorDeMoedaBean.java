package org.codeoshare.cdi.sessionbeans;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class LancadorDeMoedaBean {
	
	private String resultado;
	
	public void lanca() {
		if (Math.random() < 0.5) {
			this.resultado = "CARA";
		} else {
			this.resultado = "COROA";
		}
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
