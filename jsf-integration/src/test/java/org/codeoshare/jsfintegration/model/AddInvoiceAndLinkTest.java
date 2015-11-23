package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddInvoiceAndLinkTest {
	@Test
	public void testAddBookAndAuthor() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Link link1 = new Link();
		link1.setDuration(160);
		
		Link link2 = new Link();
		link2.setDuration(322);
		
		Invoice invoice = new Invoice();
		invoice.setExpiration(new GregorianCalendar(2015, 11, 21));
		
		invoice.getLinks().add(link1);
		invoice.getLinks().add(link2);
		
		link1.setInvoice(invoice);
		link2.setInvoice(invoice);
		
		manager.persist(invoice);
		manager.persist(link1);
		manager.persist(link2);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
