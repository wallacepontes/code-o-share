package org.codeoshare.jsfintegration.model;

import javax.persistence.Entity;

@Entity
public class Individual extends Person {
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
