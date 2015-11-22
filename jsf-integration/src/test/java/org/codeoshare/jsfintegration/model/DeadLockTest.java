package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import org.junit.Test;


public class DeadLockTest {
	@Test
	public void testDeadLock() throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager1 = factory.createEntityManager();
		EntityManager manager2 = factory.createEntityManager();
		
		manager1.getTransaction().begin();
		manager2.getTransaction().begin();
		
		manager1.find(Account.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		System.out.println("Product dead lock");
		manager2.find(Account.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		System.out.println("This message will not print.");
		Account a1 = manager1.find(Account.class, 1L);
				
		manager1.getTransaction().commit();
		manager2.getTransaction().commit();
		
		manager1.close();
		manager2.close();
		factory.close();
		
		assertTrue(true);
	}
}
