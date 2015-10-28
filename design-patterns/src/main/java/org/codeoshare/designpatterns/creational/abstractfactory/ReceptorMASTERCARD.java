package org.codeoshare.designpatterns.creational.abstractfactory;

public class ReceptorMASTERCARD implements Receptor {
	public String recebe() {
		System.out.println("Recebendo por MASTERCARD a mensagem");
		return "MASTERCARD";
	}
}
