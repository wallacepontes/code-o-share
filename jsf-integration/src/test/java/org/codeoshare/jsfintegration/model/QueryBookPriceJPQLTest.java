package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;


public class QueryBookPriceJPQLTest {
	@Test
	public void testQueryCommonObjectsJPQL () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		TypedQuery<Double> query = manager
				.createQuery("select avg(b.price) from Book b", Double.class);
		Double averagePrice = query.getSingleResult();
		
		System.out.println("Average price : " + averagePrice);
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
