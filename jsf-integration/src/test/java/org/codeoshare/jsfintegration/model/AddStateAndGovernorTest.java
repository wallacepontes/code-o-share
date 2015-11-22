package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddStateAndGovernorTest {
	@Test
	public void testAdicionaEstadoGovernador() throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Governor g = new Governor();
		g.setName("Fulano Sicrano");
		
		State e = new State();
		e.setName("Rio de Janeiro");
		e.setGovernador(g);
		
		manager.persist(g);
		manager.persist(e);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
