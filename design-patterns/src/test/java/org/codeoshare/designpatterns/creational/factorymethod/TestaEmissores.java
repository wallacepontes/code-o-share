package org.codeoshare.designpatterns.creational.factorymethod;


public class TestaEmissores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EmissorCreator creatorA = new EmissorAssincronoCreator();
		EmissorCreator creatorS = new EmissorSincronoCreator();
		//SMS		
		Emissor emissor1 = creatorA.create(EmissorCreator.SMS);
		emissor1.envia("Msg 1");
		//
		Emissor emissor2 = creatorS.create(EmissorCreator.EMAIL);
		emissor2.envia("Msg 2");
		//
		Emissor emissor3 = creatorA.create(EmissorCreator.JMS);
		emissor3.envia("Msg 3");
	}
}
