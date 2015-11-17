package org.codeoshare.jsf.controller.bean;

import javax.faces.bean.ManagedBean;

import org.codeoshare.jsf.model.entities.CPF;

@ManagedBean
public class CPFBean {

	@org.codeoshare.jsf.controller.beanvalidators.CPF
	private CPF cpf;

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}



}
