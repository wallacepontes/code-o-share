package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import org.junit.Test;

public class FindPersonTest {

	@Test
	public void testFindPerson() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();

		Person p = manager.find(Person.class, 1L);

		System.out.println("Id: " + p.getId());
		System.out.println("Name: " + p.getFirstName() + " " + p.getLastName());
		
		manager.close();
		factory.close();
		
		assertNotNull(p);
	}
}
