package org.codeoshare.jsfintegration.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;


public class ListProductsWithNativeQueryTest {
	@Test
	public void testListProductsWithNativeQuery () throws Exception {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cos_jsfintegrationdb-pu");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "Select * from cos_product";
		Query nativeQuery = manager.createNativeQuery(sql, Product.class);
		
		List<Product> products = nativeQuery.getResultList();
		
		for (Product product : products) {
			System.out.println("Product : " + product.getName());
		}

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
