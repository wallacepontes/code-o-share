package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddOrderAndClientTest {
	@Test
	public void testAddOrderAndClient() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Client c = new Client();
		c.setName("Fulano");
		
		Order o = new Order();
		o.setDate(Calendar.getInstance());
		o.setClient(c);
		
		manager.persist(c);
		manager.persist(o);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
