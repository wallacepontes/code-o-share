package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AddStateAndGovernorWithCascadeTest {
	@Test
	public void testAdicionaEstadoGovernadorWithCascade() throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		Governor g = new Governor();
		g.setName("Fulano Emiliano");
		
		State e = new State();
		e.setName("Santa Catarina");
		e.setGovernador(g);
		
		g.setState(e);
		e.setGovernador(g);
		
		manager.getTransaction().begin();
		
		manager.persist(e);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
