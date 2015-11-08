package org.codeoshare.designpatterns.creational.singleton;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testSingleton() throws Exception {
		Configuration configuracao = Configuration.getInstance();
		
		Configuration configuracao2 = Configuration.getInstance();
		
		System.out.println(configuracao.getPropriedade("time-zone"));
		System.out.println(configuracao.getPropriedade("currency-code"));
		
		assertEquals(configuracao, configuracao2);
	}
}
