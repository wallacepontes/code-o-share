package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.junit.Test;


public class IndexingPersonTest {
	@Test
	public void testIndexingPerson () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		FullTextEntityManager ft = Search.getFullTextEntityManager(manager);
		ft.createIndexer().startAndWait();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
