package org.codeoshare.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeserializadorTest {

	@Test
	public void testDeserializador() throws Exception {
		JAXBContext context = JAXBContext.newInstance(Conta.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Conta conta = (Conta) unmarshaller.unmarshal(new File("target/conta.xml"));
		
		System.out.println(conta.getLimite());
		System.out.println(conta.getSaldo());
		System.out.println(conta.getCliente().getNome());

		assertTrue(true);
	}
}
