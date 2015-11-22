package org.codeoshare.jsfintegration.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListCarsWithJPATest {

	@Test
	public void testListCarsWithJPA() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();

		CarRepository carRepository = new CarRepository(manager);

		List<Car> cars = carRepository.getAll();
		for (Car car : cars) {
			System.out.printf("%d : %s - %s\n", car.getId(), car.getBrand(), car.getModel());
		}

		manager.close();
		factory.close();
		
		assertNotNull(cars);
	}
}
