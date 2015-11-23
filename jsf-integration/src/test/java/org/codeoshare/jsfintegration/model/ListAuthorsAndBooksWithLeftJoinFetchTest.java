package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class ListAuthorsAndBooksWithLeftJoinFetchTest {

	@Test
	public void testListAuthorsAndBooks() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery(
				"select distinct(a) from Author a left join fetch a.books");
		List<Author> authors = query.getResultList();
		System.out.println();
		
		for (Author author : authors) {
			System.out.println("Author: " + author.getName());
			Collection<Book> books = author.getBooks();
			
			for (Book book : books) {
				System.out.println("Book : " + book.getName());
			}
			System.out.println();
		}

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
