package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddPersonWithoutNameTest {
	@Test
	public void testAddPerson () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person p = new Person();

		try {
			manager.persist(p);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(true);
			return;
		}
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(false);
	}
}
