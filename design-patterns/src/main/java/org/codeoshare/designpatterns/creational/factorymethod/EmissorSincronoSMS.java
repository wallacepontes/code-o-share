package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorSincronoSMS extends EmissorSMS implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando sincrono por SMS a mensagem");
		System.out.println(mensagem);
	}
}
