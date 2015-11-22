package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddAccountTest {
	@Test
	public void testAddAccount () throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Account a = new Account();
		a.setSaldo(2000);
		
		manager.persist(a);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
