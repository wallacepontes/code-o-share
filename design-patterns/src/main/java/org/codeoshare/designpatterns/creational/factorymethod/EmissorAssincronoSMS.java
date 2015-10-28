package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorAssincronoSMS extends EmissorSMS implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando assincrono por SMS a mensagem");
		System.out.println(mensagem);
	}
}
