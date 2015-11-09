package org.codeoshare.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.codeoshare.hibernate.entities.Produto;
import org.codeoshare.hibernate.repository.ProdutoRepository;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListaProdutosComJPATest {

	@Test
	public void testListaProdutosComJPA() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateexampleDB-pu");
		EntityManager manager = factory.createEntityManager();

		ProdutoRepository produtoRepository = new ProdutoRepository(manager);

		List<Produto> produtos = produtoRepository.buscaTodos();
		for (Produto produto : produtos) {
			System.out.printf("%d : %s -R$ %s\n", produto.getId(), produto.getNome(), produto.getPreco());
		}

		manager.close();
		factory.close();
		
		assertNotNull(produtos);
	}
}
