package org.codeoshare.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import static org.junit.Assert.*;
import org.junit.Test;

public class SerializadorTest {

	@Test
	public void testSerializador() throws Exception {
		JAXBContext context = JAXBContext.newInstance(Conta.class);
		Marshaller marshaller = context.createMarshaller();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Wallace Pontes");
		
		Conta conta = new Conta();
		conta.setLimite(2000);
		conta.setSaldo(1000);
		conta.setCliente(cliente);
		
		marshaller.marshal(conta, new File("target/conta.xml"));

		assertTrue(true);
	}

}
