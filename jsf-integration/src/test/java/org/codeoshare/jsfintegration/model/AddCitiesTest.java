package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddCitiesTest {
	@Test
	public void testAddCities () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		City rj = new City();
		rj.setName("Rio de Janeiro");
		rj.setState("RJ");
		
		City fort = new City();
		fort.setName("Fortaleza");
		fort.setState("CE");
		
		City cha = new City();
		cha.setName("Chapecó");
		cha.setState("SC");
		
		manager.persist(rj);
		manager.persist(fort);
		manager.persist(cha);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
