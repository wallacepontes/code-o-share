package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class FetchBooksWithMaxResultsTest {
	@Test
	public void testFetchBooksWithMaxResults() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Book> query = manager.createQuery("select b from Book b", 
				Book.class);
		query.setFirstResult(2);
		query.setMaxResults(3);
		List<Book> books = query.getResultList();
		
		for (Book book : books) {
			System.out.println("Book:" + book.getName());
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
