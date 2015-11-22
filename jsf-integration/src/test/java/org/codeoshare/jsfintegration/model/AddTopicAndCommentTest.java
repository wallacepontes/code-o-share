package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class AddTopicAndCommentTest {
	@Test
	public void testAddTopicAndComment() throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
				
		Topic t = new Topic();
		t.setTitle("Orphan Removal");
		
		for (int i = 0; i < 10; i++) {
			Comment c = new Comment();
			c.setData(Calendar.getInstance());
			t.getComments().add(c);
		}
		
		manager.getTransaction().begin();

		manager.persist(t);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
