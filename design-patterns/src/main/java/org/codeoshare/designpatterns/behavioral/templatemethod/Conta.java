package org.codeoshare.designpatterns.behavioral.templatemethod;

public abstract class Conta {
    private double saldo;
    
    public void deposita(double valor) {
    	this.saldo += valor;
    	this.saldo -= this.calculaTaxa();
    }
    
    public void saca(double valor) {
    	this.saldo -= valor;
    	this.saldo -= this.calculaTaxa();
    }
    
    public double getSaldo() {
    	return this.saldo;
    }
    
    public abstract double calculaTaxa();
}
