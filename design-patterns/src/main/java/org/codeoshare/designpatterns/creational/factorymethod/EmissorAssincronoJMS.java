package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorAssincronoJMS extends EmissorJMS implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando assincrono por JMS a mensagem");
		System.out.println(mensagem);
	}
}
