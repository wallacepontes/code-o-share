package org.codeoshare.designpatterns.structural.proxy;

public class ContaProxy implements Conta {
    private Conta conta;
    
    public ContaProxy(Conta conta) {
    	this.conta = conta;
    }

	public void deposita(double valor) {
		System.out.println("Efetuando o depósito de R$ " + valor + " ...");
		this.conta.deposita(valor);
		System.out.println("Depósito efetuado de R$ " + valor);
	}

	public void saca(double valor) {
		System.out.println("Efetuando o saque de R$ "+ valor);
		this.conta.saca(valor);
		System.out.println("Saque efetuado de R$ "+ valor);
	}

	public double getSaldo() {
        System.out.println("Verificando o saldo...");
		return this.conta.getSaldo();
	}
}
