package org.codeoshare.jsf.controller.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PrimoBean {

	private Long numeroPrimo;

	public Long getNumeroPrimo() {
		return numeroPrimo;
	}

	public void setNumeroPrimo(Long numeroPrimo) {
		this.numeroPrimo = numeroPrimo;
	}
}
