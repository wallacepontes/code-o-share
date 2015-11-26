package org.codeoshare.primefaces.controle;

import java.util.Date;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class CalendarBean {
	private Date dataDeNascimento;

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}



}
