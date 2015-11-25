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

public class ListBooksFromCriteriaTest {

	@Test
	public void testListBooksFromCriteria() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Book> c = cb.createQuery(Book.class);
		Root<Book> b = c.from(Book.class);
		c.select(b);
		
		TypedQuery<Book> query = manager.createQuery(c);
		List<Book> books = query.getResultList();
		
		for (Book book : books) {
			System.out.println("Book : " + book.getName());
		}

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
