package org.codeoshare.designpatterns.behavioral.templatemethod;

public class ContaCorrente extends Conta {

	@Override
	public double calculaTaxa() {
		return 3;
	}
}
