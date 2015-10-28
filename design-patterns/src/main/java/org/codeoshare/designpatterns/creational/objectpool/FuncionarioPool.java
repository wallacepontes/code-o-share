package org.codeoshare.designpatterns.creational.objectpool;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioPool implements Pool<Funcionario> {
    private List<Funcionario> funcionarios;
	public FuncionarioPool() {
		this.funcionarios = new ArrayList<Funcionario>();
		this.funcionarios.add(new Funcionario("Wallace Pontes"));
		this.funcionarios.add(new Funcionario("Lucas Pontes"));
		this.funcionarios.add(new Funcionario("Eliane Mates"));
	}

	public Funcionario acquire() {
		if (this.funcionarios.size() > 0) {
			return this.funcionarios.remove(0);
		} else {
			return null;
		}
	}

	public void release(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
		
	}
}
