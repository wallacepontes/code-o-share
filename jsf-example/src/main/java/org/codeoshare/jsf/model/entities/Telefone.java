package org.codeoshare.jsf.model.entities;

public class Telefone {
	private String codigoDoPais;
	private String codigoDeArea;
	private String numeroLocal;

	public Telefone(String codigoDoPais, String codigoDeArea, String numeroLocal) {
		super();
		this.codigoDoPais = codigoDoPais;
		this.codigoDeArea = codigoDeArea;
		this.numeroLocal = numeroLocal;
	}

	public String getCodigoDoPais() {
		return codigoDoPais;
	}
	public void setCodigoDoPais(String codigoDoPais) {
		this.codigoDoPais = codigoDoPais;
	}
	public String getCodigoDeArea() {
		return codigoDeArea;
	}
	public void setCodigoDeArea(String codigoDeArea) {
		this.codigoDeArea = codigoDeArea;
	}
	public String getNumeroLocal() {
		return numeroLocal;
	}
	public void setNumeroLocal(String numeroLocal) {
		this.numeroLocal = numeroLocal;
	}	
}
