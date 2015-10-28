package org.codeoshare.designpatterns.structural.proxy;

public interface Conta {
	
	void deposita(double valor);
	void saca(double valor);
	double getSaldo();
}
