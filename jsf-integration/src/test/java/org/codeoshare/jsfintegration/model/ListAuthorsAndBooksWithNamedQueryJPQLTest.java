package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;


public class ListAuthorsAndBooksWithNamedQueryJPQLTest {
	@Test
	public void testListAuthorsAndBooksWithNamedQueryJPQL () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createNamedQuery("Author.findAll");
		List<Author> authors = query.getResultList();
		
		for (Author author : authors) {
			System.out.println("Authors : "  + author.getName());
			Collection<Book> books = author.getBooks();
			for (Book book : books) {
				System.out.println("Book : " + book.getName());
				System.out.println("Price : " + book.getPrice());
				System.out.println();
			}
			System.out.println();
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
