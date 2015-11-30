package org.codeoshare.transaction.sessionbeans;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.codeoshare.transaction.entidades.Produto;

@Stateless
public class ProdutoRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Resource
	private SessionContext context;

	public void adiciona(Produto produto) {
		this.manager.persist(produto);
		if (produto.getPreco() < 0) {
			this.context.setRollbackOnly();
		}
	}

	public List<Produto> getProdutos() {
		TypedQuery<Produto> query = this.manager.createQuery("select x from Produto x", Produto.class);

		return query.getResultList();
	}

}
