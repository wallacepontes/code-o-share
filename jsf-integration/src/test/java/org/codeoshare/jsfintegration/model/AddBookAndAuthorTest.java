package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddBookAndAuthorTest {
	@Test
	public void testAddBookAndAuthor() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Author a = new Author();
		a.setName("Sicrano");

		Book b = new Book();
		b.setName("Fulano");
		b.getAuthors().add(a);
		
		manager.persist(a);
		manager.persist(b);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
