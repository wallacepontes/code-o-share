package org.codeoshare.jsfintegration.model;

import javax.persistence.Entity;

@Entity
public class Corporate extends Person{
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
