package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class QueryNameAndPriceOfBooksFromTupleCriteriaTest {

	@Test
	public void testQueryNameAndPriceOfBooksWithCriteria() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c = cb.createQuery(Tuple.class);
		Root<Book> b = c.from(Book.class);
		c.multiselect(b.<String>get("name").alias("book.name"),
				b.<Double>get("price").alias("book.price"));
		
		TypedQuery<Tuple> query = manager.createQuery(c);
		List<Tuple> result = query.getResultList();
				
		for (Tuple register : result) {
			System.out.println("Book : " + register.get("book.name"));
			System.out.println("Price : " + register.get("book.price"));
		}
				
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
