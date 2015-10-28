package org.codeoshare.designpatterns.behavioral.templatemethod;

public class ContaPoupanca extends Conta {

	@Override
	public double calculaTaxa() {
		return 1;
	}
}
