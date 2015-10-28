package org.codeoshare.designpatterns.creational.abstractfactory;

public class EmissorVISA implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando por VISA a mensagem");
		System.out.println(mensagem);
	}
}
