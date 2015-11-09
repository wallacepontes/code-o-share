package org.codeoshare.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.codeoshare.hibernate.entities.Produto;
import org.codeoshare.hibernate.repository.ProdutoRepository;

import static org.junit.Assert.*;
import org.junit.Test;

public class InsereProdutoComJPATest {

	@Test
	public void testInsereProdutoComJPA() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateexampleDB-pu");
		EntityManager manager = factory.createEntityManager();

		ProdutoRepository produtoRepository = new ProdutoRepository(manager);

		Produto novoProduto = new Produto();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o nome do produto: ");
		novoProduto.setNome(entrada.nextLine());

		System.out.println("Digite o preço do produto: ");
		novoProduto.setPreco(Double.parseDouble(entrada.nextLine()));

		produtoRepository.adiciona(novoProduto);

		manager.getTransaction().begin();
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		
		assertTrue(true);
	}
}
