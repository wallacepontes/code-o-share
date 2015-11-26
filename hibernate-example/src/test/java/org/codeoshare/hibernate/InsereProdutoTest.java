package org.codeoshare.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.codeoshare.hibernate.entities.Produto;

import static org.junit.Assert.*;
import org.junit.Test;

public class InsereProdutoTest {

	@Test
	public void testInsereProduto() throws Exception {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cos_hibernateexampleDB-pu");
        EntityManager em = factory.createEntityManager();

        Produto p = new Produto();
        p.setNome("Calça");
        p.setPreco(29.8);

        Produto p2 = em.find(Produto.class, 3);
        p2.setNome("vestido");
        p2.setPreco(11.5);

        Produto p3 = em.find(Produto.class, 4);
        p3.setNome("chapeú");
        p3.setPreco(4.2);

        em.getTransaction().begin();

        em.persist(p);

        em.getTransaction().commit();

        Query query = em.createQuery("SELECT p FROM Produto p");
        List<Produto> produtos = query.getResultList();
        for (Produto produto : produtos) {
			System.out.printf("%d : %s -R$ %s\n", produto.getId(), produto.getNome(), produto.getPreco());
		}

        em.close();
        factory.close();

        assertTrue(true);
	}
}
