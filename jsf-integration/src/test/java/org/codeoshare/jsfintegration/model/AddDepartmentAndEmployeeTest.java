package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddDepartmentAndEmployeeTest {
	@Test
	public void testAddDepartmentAndEmployee() throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Employee e = new Employee();
		e.setName("Fulano");
		
		Department d = new Department();
		d.setName("Dep Sicrano");

		d.getEmployee().add(e);
		
		manager.persist(e);
		manager.persist(d);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
