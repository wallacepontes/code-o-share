package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class FetchDepartmentAndEmployeeTest {
	@Test
	public void testFetchDepartmentAndEmployee() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager
			.createQuery("select e.name, e.department.name from Employee e");
		List<Object[]> list = query.getResultList();
		
		for (Object[] o : list) {
			System.out.println("Employee: " + o[0]);
			System.out.println("Department: "+ o[1]);
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
