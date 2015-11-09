package org.codeoshare.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codeoshare.hibernate.entities.Produto;

public class ProdutoRepository {
    private EntityManager manager;

	public ProdutoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Produto produto) {
		this.manager.persist(produto);
	}
    public Produto busca(int id){
    	return this.manager.find(Produto.class, id);
    }
    public List<Produto> buscaTodos() {
    	Query query = this.manager.createQuery("SELECT p FROM Produto p");
    	return query.getResultList();
    }

}
