package org.codeoshare.designpatterns.creational.factorymethod;

import static org.junit.Assert.*;
import org.junit.Test;

public class EmissoresTest {

	@Test
	public void testFactoryMethod() throws Exception {
		
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
		
		assertTrue(true);
	}
}
