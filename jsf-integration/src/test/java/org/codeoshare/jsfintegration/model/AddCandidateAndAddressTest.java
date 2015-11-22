package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddCandidateAndAddressTest {
	@Test
	public void testAddCandidateAndAddress() throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Address a = new Address();
		a.setState("Rio de Janeiro");
		a.setCity("Rio de Janeiro");
		a.setLogradouro("Av. Presidente Vargas");
		a.setNumber(1000);
		
		Candidate c = new Candidate();
		c.setName("Fulano");
		c.setBirth(new GregorianCalendar(1978,11,5));
		c.setAddress(a);
		
		manager.persist(c);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
