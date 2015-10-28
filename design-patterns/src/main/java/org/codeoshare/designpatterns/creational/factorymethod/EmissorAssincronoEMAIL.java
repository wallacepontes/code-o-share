package org.codeoshare.designpatterns.creational.factorymethod;

public class EmissorAssincronoEMAIL extends EmissorEmail implements Emissor {
	public void envia(String mensagem) {
		System.out.println("Enviando assincrono por EMAIL a mensagem");
		System.out.println(mensagem);
	}
}
