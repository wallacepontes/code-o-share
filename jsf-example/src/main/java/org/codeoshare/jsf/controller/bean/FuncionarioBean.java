package org.codeoshare.jsf.controller.bean;

import javax.faces.bean.ManagedBean;

import org.codeoshare.jsf.model.entities.Funcionario;

@ManagedBean
public class FuncionarioBean {
	private Funcionario funcionario = new Funcionario();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


}

