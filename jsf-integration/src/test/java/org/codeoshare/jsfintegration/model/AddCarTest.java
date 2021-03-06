package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddCarTest {
	@Test
	public void testAddCar () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Car car = new Car();
		car.setBrand("Fiat");
		car.setModel("Uno");
		
		manager.persist(car);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
