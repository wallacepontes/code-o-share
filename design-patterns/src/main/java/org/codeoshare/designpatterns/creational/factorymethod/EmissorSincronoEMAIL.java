package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorSincronoEMAIL extends EmissorEmail implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando sincrono por EMAIL a mensagem");
		System.out.println(mensagem);
	}
}
