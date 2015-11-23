package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;


public class ListBooksWithParametersJPQLTest {
	@Test
	public void testListBooksWithParametersJPQL () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("Book.findByMinimumPrice");
		query.setParameter("price", 2.2);
		List<Book> books = query.getResultList();
		
		for (Book book : books) {
			System.out.println("Book : " + book.getName());
			System.out.println("Price : " + book.getPrice());
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
