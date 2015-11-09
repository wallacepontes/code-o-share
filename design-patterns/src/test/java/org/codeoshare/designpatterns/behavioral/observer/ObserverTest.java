package org.codeoshare.designpatterns.behavioral.observer;

import static org.junit.Assert.*;
import org.junit.Test;

public class ObserverTest {

	@Test
	public void testObserver() throws Exception {
		Acao acao = new Acao("VALE3", 36.27);
		
		Corretora corretora1 = new Corretora("Corretora1");
		Corretora corretora2 = new Corretora("Corretora2");
		
		acao.registraInteressado(corretora1);
		acao.registraInteressado(corretora2);
		
		acao.setValor(41.22);

		assertTrue(true);
	}
}
