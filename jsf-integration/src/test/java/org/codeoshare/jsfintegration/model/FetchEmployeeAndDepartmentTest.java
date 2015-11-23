package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class FetchEmployeeAndDepartmentTest {
	@Test
	public void testFetchDepartmentAndEmployee() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager
			.createQuery("select new org.codeoshare.jsfintegration.model."
					+ "EmployeeDepartmentReport(e.name, e.department.name) "
					+ "from Employee e");
		List<EmployeeDepartmentReport> list = query.getResultList();
		
		for (EmployeeDepartmentReport ed : list) {
			System.out.println("Employee: " + ed.getEmployee());
			System.out.println("Department: "+ ed.getDepartment());
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
