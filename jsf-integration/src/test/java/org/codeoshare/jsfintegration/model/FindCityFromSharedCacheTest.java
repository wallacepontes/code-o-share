package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import org.junit.Test;

public class FindCityFromSharedCacheTest {

	@Test
	public void testFindCityFromSharedCache() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager1 = factory.createEntityManager();

		System.out.println(".............  First Find ................. ");
		City c = manager1.find(City.class, 3L);
		
		EntityManager manager2 = factory.createEntityManager();

		System.out.println(".............  Second Find ................. ");
		c = manager2.find(City.class, 4L);
		
		manager1.close();
		manager2.close();
		factory.close();
		
		assertTrue(true);
	}
}
