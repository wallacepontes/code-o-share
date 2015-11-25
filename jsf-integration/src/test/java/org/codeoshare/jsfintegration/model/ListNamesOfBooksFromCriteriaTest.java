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

public class ListNamesOfBooksFromCriteriaTest {

	@Test
	public void testListNamesOfBooksFromCriteria() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<String> c = cb.createQuery(String.class);
		Root<Book> b = c.from(Book.class);
		c.select(b.<String>get("name"));
		
		TypedQuery<String> query = manager.createQuery(c);
		List<String> names = query.getResultList();
		
		for (String name : names) {
			System.out.println("Book : " + name);
		}

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
