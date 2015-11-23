package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;


public class ListAuthorsWithTypedQueryJPQLTest {
	@Test
	public void testListAuthorsWithTypedQueryJPQL () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		TypedQuery<Author> query = manager.createNamedQuery("Author.findAll", Author.class);
		List<Author> authors = query.getResultList();
		
		for (Author author : authors) {
			System.out.println("Authors : "  + author.getName());
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
