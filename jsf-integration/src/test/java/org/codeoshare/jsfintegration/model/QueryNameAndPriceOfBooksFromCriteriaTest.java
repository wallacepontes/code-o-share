package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class QueryNameAndPriceOfBooksFromCriteriaTest {

	@Test
	public void testQueryNameAndPriceOfBooksFromCriteria() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> c = cb.createQuery(Object[].class);
		Root<Book> b = c.from(Book.class);
		c.multiselect(b.<String>get("name"),b.<Double>get("price"));
		
		TypedQuery<Object[]> query = manager.createQuery(c);
		List<Object[]> result = query.getResultList();
		
		for (Object[] register : result) {
			System.out.println("Book : " + register[0]);
			System.out.println("Price : " + register[1]);
		}
				
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
