package org.codeoshare.designpatterns.structural.decorator;

public class EmissorBasivo implements Emissor {

	public void envia(String mensagem) {
		System.out.println("Enviando uma mensagem: ");
		System.out.println(mensagem);
	}
}
