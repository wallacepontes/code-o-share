package org.codeoshare.designpatterns.creational.abstractfactory;

public class ReceptorVISA implements Receptor {
	public String recebe() {
		System.out.println("Recebendo por VISA a mensagem");
		return "VISA";
	}
}
