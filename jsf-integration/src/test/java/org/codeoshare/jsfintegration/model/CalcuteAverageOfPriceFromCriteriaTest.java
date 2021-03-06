package org.codeoshare.jsfintegration.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcuteAverageOfPriceFromCriteriaTest {

	@Test
	public void testCalcuteAverageOfPriceFromCriteria() throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Double> c = cb.createQuery(Double.class);
		Root<Book> b = c.from(Book.class);
		c.select(cb.avg(b.<Double>get("price")));
		
		TypedQuery<Double> query = manager.createQuery(c);
		Double average = query.getSingleResult();
		
		System.out.println("Average : " + average);

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
