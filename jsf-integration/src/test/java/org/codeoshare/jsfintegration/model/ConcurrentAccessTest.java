package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class ConcurrentAccessTest {
	@Test
	public void testConcurrentAccess () throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager1 = factory.createEntityManager();
		EntityManager manager2 = factory.createEntityManager();
		
		manager1.getTransaction().begin();
		manager2.getTransaction().begin();
		
		Account a1 = manager1.find(Account.class, 1L);
		
		a1.setSaldo(a1.getSaldo() + 500);
		
		Account a2 = manager2.find(Account.class, 1L);
		
		a2.setSaldo(a2.getSaldo() - 500);
		
		manager1.getTransaction().commit();
		manager2.getTransaction().commit();
		
		manager1.close();
		manager2.close();
		factory.close();
		
		assertTrue(true);
	}
}
