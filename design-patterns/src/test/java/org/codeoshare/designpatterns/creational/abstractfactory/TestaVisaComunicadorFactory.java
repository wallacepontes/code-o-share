package org.codeoshare.designpatterns.creational.abstractfactory;

import org.codeoshare.designpatterns.creational.factorymethod.Emissor;

public class TestaVisaComunicadorFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComunicadorFactory comunicadorFactory = new VisaComunicadorFactory();
		
		String transacao = "Valor=560;Senha=123";
		Emissor emissor = comunicadorFactory.createEmissor();
		emissor.envia(transacao);
		
		Receptor receptor = comunicadorFactory.createReceptor();
		String mensagem = receptor.recebe();
		System.out.println(mensagem);

	

	
	//
	Cartao cartao = new Cartao();
	cartao.setBandeira("Mastercard");
	ComunicadorFactory factory = getComunicadorFactory(cartao);
	//String transacao = "BLABLABLABLA";
	//Emissor emissor = factory.getEmissor();
	//emissor.envia(transacao);
	//Receptor receptor = factory.getReceptor();
	String resposta = receptor.recebe();
}

public static ComunicadorFactory getComunicadorFactory(Cartao cartao) {
	String bandeira = cartao.getBandeira();
	Class clazz;
	try {
		clazz = Class.forName(bandeira + "ComunicadorFactory");
		return (ComunicadorFactory) clazz.newInstance();
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

}

}
