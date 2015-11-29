package org.codeoshare.carrinho.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.codeoshare.carrinho.sessionbeans.Carrinho;

@ManagedBean
@SessionScoped
public class CarrinhoMB {
	@EJB
	private Carrinho carrinhoBean;

	private String produto;

	public List<String> getProdutos() {
		return new ArrayList<String>(this.carrinhoBean.getProdutos());
	}

	public void adiciona() {
		this.carrinhoBean.adiciona(this.produto);
	}

	public void remove(String produto) {
		this.carrinhoBean.remove(produto);
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getProduto() {
		return this.produto;
	}

}
