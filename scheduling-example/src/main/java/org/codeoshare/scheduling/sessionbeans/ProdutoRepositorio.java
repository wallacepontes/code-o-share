package org.codeoshare.scheduling.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.codeoshare.scheduling.entities.Produto;

@Stateless
public class ProdutoRepositorio {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Produto produto) {
		this.manager.persist(produto);
	}
	
	public List<Produto> getProdutos() {
		TypedQuery<Produto> query = this.manager.createQuery("select x from Produto x", Produto.class);
		
		return query.getResultList();
	}

}
