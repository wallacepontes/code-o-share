package org.codeoshare.carrinho;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import static org.junit.Assert.*;
import org.junit.Test;

import org.codeoshare.carrinho.sessionbeans.Carrinho;

public class CicloDeVisaSFSBTest {
	
	@Test
	public void testCicloDeVisaSFSB() throws Exception {
		/*Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447");
		props.put(Context.SECURITY_PRINCIPAL, "codeoshare");
		props.put(Context.SECURITY_CREDENTIALS, "codeoshare");
		props.put("jboss.naming.client.ejb.context", true); 
        */
		InitialContext ic = new InitialContext();

		Carrinho[] carrinhos = new Carrinho[6];

		for (int i = 0; i < carrinhos.length; i++) {
			//carrinhos[i] = (Carrinho) ic.lookup("CarrinhoWeb/CarrinhoBean!org.codeoshare.carrinho.sessionbeans.Carrinho");
			carrinhos[i] = (Carrinho) ic.lookup("java:global/carrinho-war/CarrinhoBean");
			carrinhos[i].adiciona("Chaveiro - Code-O-Share");
			carrinhos[i].adiciona("Caneta - Code-O-Share");
			Thread.sleep(1000);
		}

		carrinhos[0].adiciona("Borracha - Code-O-Share");

		Thread.sleep(500);

		carrinhos[0].finalizaCompra();
		
		assertTrue(true);
	}
}
