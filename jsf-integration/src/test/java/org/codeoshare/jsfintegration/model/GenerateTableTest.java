package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class GenerateTableTest {
	@Test
	public void testGenerateTable () throws Exception {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb-pu");

		factory.close();
		
		assertTrue(true);
	}
}
