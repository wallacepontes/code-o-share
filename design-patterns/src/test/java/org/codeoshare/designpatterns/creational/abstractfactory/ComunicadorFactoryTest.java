package org.codeoshare.designpatterns.creational.abstractfactory;

import org.codeoshare.designpatterns.creational.factorymethod.Emissor;

import static org.junit.Assert.*;
import org.junit.Test;

public class ComunicadorFactoryTest {

	/**
	 * Test the simple scenario of the factory senders and receivers Visa.
	 * 
	 * @param args
	 */
	@Test
	public void testVisaAbstractFactory() throws Exception {
		ComunicadorFactory comunicadorFactory = new VisaComunicadorFactory();
		
		String transacao = "Valor=120;Senha=bola";
		Emissor emissor = comunicadorFactory.createEmissor();
		emissor.envia(transacao);
		
		Receptor receptor = comunicadorFactory.createReceptor();
		String mensagem = receptor.recebe();
		
		assertEquals("VISA", mensagem);
    }

	/**
	 * Test the simple scenario of the factory senders and receivers Mastercard.
	 * 
	 * @param args
	 */
	@Test
	public void testMastercardAbstractFactory() throws Exception {
		ComunicadorFactory comunicadorFactory = new MastercardComunicadorFactory();
		
		String transacao = "Valor=330;Senha=mala";
		Emissor emissor = comunicadorFactory.createEmissor();
		emissor.envia(transacao);
		
		Receptor receptor = comunicadorFactory.createReceptor();
		String mensagem = receptor.recebe();
		
		assertEquals("MASTERCARD", mensagem);
    }
}
