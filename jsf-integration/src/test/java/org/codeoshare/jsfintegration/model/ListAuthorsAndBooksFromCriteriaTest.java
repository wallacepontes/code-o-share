package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class ListAuthorsAndBooksFromCriteriaTest {

	@Test
	public void testListAuthorsAndBooksFromCriteria() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Author> c = cb.createQuery(Author.class);
		Root<Author> a = c.from(Author.class);
		c.select(a);
		
		
		TypedQuery<Author> query = manager.createQuery(c);
		List<Author> authors = query.getResultList();
		
		for (Author author : authors) {
			System.out.println("Author : " + author.getName());
			Collection<Book> books = author.getBooks();
			for (Book book : books) {
				System.out.println("Book: " + book.getName());
				
			}
			System.out.println();
		}

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
