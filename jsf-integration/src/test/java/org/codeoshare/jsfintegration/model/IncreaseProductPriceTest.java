package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;


public class IncreaseProductPriceTest {
	@Test
	public void testIncreaseProductPrice () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Query query = manager
				.createQuery("UPDATE Product p SET p.price = p.price * 1.1");
		
		query.executeUpdate();
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
