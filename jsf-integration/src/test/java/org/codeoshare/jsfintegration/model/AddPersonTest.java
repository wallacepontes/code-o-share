package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddPersonTest {
	@Test
	public void testAddPerson () throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person p1 = new Person();
		p1.setFirstName("Sicrano");
		p1.setLastName("Emilano");
		p1.getAddress().setCep(1234);
		
		Individual p2 = new Individual();
		p2.setFirstName("Fulano");
		p2.setLastName("Sicrano");
		p2.setCpf("123456");
		p2.getAddress().setCep(5648);
		
		Corporate p3 = new Corporate();
		p3.setFirstName("Beltrano");
		p3.setLastName("Sicrano");
		p3.setCnpj("987654321");
		p3.getAddress().setCep(9856);
		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
