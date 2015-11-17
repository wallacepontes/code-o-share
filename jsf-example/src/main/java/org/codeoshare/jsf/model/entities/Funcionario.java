package org.codeoshare.jsf.model.entities;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Funcionario {
	@NotNull
	@Min(value = 0)
    private Double salario;

	@NotNull
	@Min(value=5)
	@Max(value=19)
    private Integer codigo;

	@NotNull
    private Date aniversario;

	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Date getAniversario() {
		return aniversario;
	}
	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}



}
