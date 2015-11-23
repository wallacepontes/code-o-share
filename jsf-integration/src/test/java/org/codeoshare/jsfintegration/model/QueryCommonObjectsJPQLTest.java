package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;


public class QueryCommonObjectsJPQLTest {
	@Test
	public void testQueryCommonObjectsJPQL () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		TypedQuery<String> query = manager
				.createQuery("select b.name from Book b", String.class);
		List<String> names = query.getResultList();
		
		for (String name : names) {
			System.out.println(name);
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
