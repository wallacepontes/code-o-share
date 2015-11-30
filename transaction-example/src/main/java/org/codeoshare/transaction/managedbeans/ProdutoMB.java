package org.codeoshare.transaction.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.codeoshare.transaction.entidades.Produto;
import org.codeoshare.transaction.sessionbeans.ProdutoRepositorio;

@ManagedBean
public class ProdutoMB {

	@EJB
	private ProdutoRepositorio repositorio;

	private Produto produto = new Produto();

	private List<Produto> produtosCache;

	public void adiciona() {
		this.repositorio.adiciona(this.produto);
		this.produto = new Produto();
		this.produtosCache = null;
	}

	public List<Produto> getProdutos() {
		if (this.produtosCache == null) {
			this.produtosCache = this.repositorio.getProdutos();
		}
		return this.produtosCache;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

}
