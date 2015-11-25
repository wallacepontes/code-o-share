package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import org.junit.Test;

public class UploadRelationshipStateAndGovernorFromFetchTypeLazyTest {

	@Test
	public void testUploadRelationshipStateAndGovernorFromFetchTypeLazy() 
			throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();

		State s = manager.find(State.class, 8L);
		
		manager.close();
		factory.close();
		
		try {
			System.out.println(s.getGovernador().getName());
		} catch (Exception e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
}
