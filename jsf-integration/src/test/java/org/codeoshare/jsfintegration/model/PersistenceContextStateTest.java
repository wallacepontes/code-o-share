package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersistenceContextStateTest {

	@Test
	public void testPersistenceContextState() 
			throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();

		System.out.println(".............  First Find ................. ");
		State s = manager.find(State.class, 8L);
		System.out.println(".............  Second Find ................. ");
		s = manager.find(State.class, 8L);
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
