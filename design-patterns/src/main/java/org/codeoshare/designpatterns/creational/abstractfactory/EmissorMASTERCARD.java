package org.codeoshare.designpatterns.creational.abstractfactory;

public class EmissorMASTERCARD implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando por MASTEDCARD a mensagem");
		System.out.println(mensagem);
	}
}
