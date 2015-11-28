package org.codeoshare.dado;

import javax.naming.InitialContext;
import static org.junit.Assert.*;
import org.junit.Test;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

public class AcessoTest {

	@Test
	public void testAcesso() throws Exception {
		InitialContext ic = new InitialContext();

		LancadorDeDado lancadorDeDado = (LancadorDeDado) ic.lookup("java:global/dado-war/LancadorDeDadoBean");
		System.out.println(lancadorDeDado.lanca());
		
		assertTrue(true);

	}

}
