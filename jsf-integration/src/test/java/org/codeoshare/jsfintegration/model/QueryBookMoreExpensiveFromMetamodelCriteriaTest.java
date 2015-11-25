package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;


public class QueryBookMoreExpensiveFromMetamodelCriteriaTest {
	@Test
	public void testQueryBookMoreExpensiveFromMetamodelCriteria () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Double> c = cb.createQuery(Double.class);
		Root<Book> b = c.from(Book.class);
		c.select(cb.max(b.get(Book_.price)));
		
		TypedQuery<Double> query = manager.createQuery(c);
		Double majorPrice = query.getSingleResult();
		
		System.out.println("Average price : " + majorPrice);
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
