package org.codeoshare.security.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grupo {

	@Id
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
