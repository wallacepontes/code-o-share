package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddBooksAndAuthorsTest {
	@Test
	public void testAddBookAndAuthor() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Book b1 = new Book();
		b1.setName("ECONOMIC POLICY: THOUGHTS FOR TODAY AND TOMORROW");
		b1.setPrice(2.1);
		manager.persist(b1);
		
		Book b2 = new Book();
		b2.setName("Essays on Political Economy");
		b2.setPrice(2.2);
		manager.persist(b2);
		
		Book b3 = new Book();
		b3.setName("The Logic of Collective Action");
		b3.setPrice(2.3);
		manager.persist(b3);
		
		Book b4 = new Book();
		b4.setName("Rational Optimist");
		b4.setPrice(2.4);
		manager.persist(b4);
		
		Book b5 = new Book();
		b5.setName("Modern Times");
		b5.setPrice(2.5);
		manager.persist(b5);
		
		Book b6 = new Book();
		b6.setName("The Battle for Your Mind");
		b6.setPrice(2.1);
		manager.persist(b6);
		
		Book b7 = new Book();
		b7.setName("Differentiate or Die");
		b7.setPrice(2.2);
		manager.persist(b7);
		
		Book b8 = new Book();
		b8.setName("How to Transform Your Ideas");
		b8.setPrice(2.3);
		manager.persist(b8);
		
		Book b9 = new Book();
		b9.setName("Digital Fortress");
		b9.setPrice(2.4);
		manager.persist(b9);
		
		Book b10 = new Book();
		b10.setName("Marketing in an Era of Competition , Change and Crisis");
		b10.setPrice(2.5);
		manager.persist(b10);
		
		Author a1 = new Author();
		a1.setName("Ludwig von Mises");
		a1.getBooks().add(b1);
		manager.persist(a1);
		
		Author a2 = new Author();
		a2.setName("Frédéric Bastiat");
		a2.getBooks().add(b2);
		manager.persist(a2);
		
		Author a3 = new Author();
		a3.setName("Mancur Olson");
		a3.getBooks().add(b3);
		manager.persist(a3);

		Author a4 = new Author();
		a4.setName("Matt Ridley");
		a4.getBooks().add(b4);
		manager.persist(a4);

		Author a5 = new Author();
		a5.setName("Paul Johnson");
		a5.getBooks().add(b5);
		manager.persist(a5);
		
		Author a6 = new Author();
		a6.setName("Patrick Cullen");
		a6.getBooks().add(b7);
		a6.getBooks().add(b9);
		manager.persist(a6);
		
		Author a7 = new Author();
		a7.setName("Fraser Seitel");
		a7.getBooks().add(b8);
		manager.persist(a7);
		
		Author a8 = new Author();
		a8.setName("Al Ries");
		a8.getBooks().add(b6);
		manager.persist(a8);

		Author a9 = new Author();
		a9.setName("Jack Trout");
		a9.getBooks().add(b6);
		a9.getBooks().add(b7);
		a9.getBooks().add(b10);
		manager.persist(a9);

		Author a10 = new Author();
		a10.setName("Steve Rivkin");
		a10.getBooks().add(b7);
		a10.getBooks().add(b8);
		a10.getBooks().add(b10);
		manager.persist(a10);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
