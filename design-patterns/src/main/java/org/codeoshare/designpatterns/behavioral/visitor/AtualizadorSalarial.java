package org.codeoshare.designpatterns.behavioral.visitor;

public class AtualizadorSalarial implements AtualizadorDeFuncionario {

	public void atualiza(Gerente g) {
		g.setSalario(g.getSalario() * 1.43);
	}

	public void atualiza(Telefonista t) {
		t.setSalario(t.getSalario() * 1.27);
	}
}
