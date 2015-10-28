package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorSincronoJMS extends EmissorJMS implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando sincrono por JMS a mensagem");
		System.out.println(mensagem);
	}
}
