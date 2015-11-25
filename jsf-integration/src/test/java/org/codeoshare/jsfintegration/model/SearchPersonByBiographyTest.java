package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.junit.Test;


public class SearchPersonByBiographyTest {
	@Test
	public void testSearchPersonByBiography () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		FullTextEntityManager ft = Search.getFullTextEntityManager(manager);
		SearchFactory sf = ft.getSearchFactory();
		QueryBuilder personQB = sf.buildQueryBuilder()
				.forEntity(Person.class).get();
		org.apache.lucene.search.Query luceneQuery = personQB.keyword()
				.onField("biography").matching("C4SS").createQuery();
		
		javax.persistence.Query jpaQuery = ft
				.createFullTextQuery(luceneQuery, Person.class);
		
		List<Person> persons = jpaQuery.getResultList();
		
		for (Person person : persons) {
			System.out.println(person.getFirstName() + " " 
				+ person.getLastName());
		}
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
