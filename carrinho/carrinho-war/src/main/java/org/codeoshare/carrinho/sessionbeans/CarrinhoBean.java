package org.codeoshare.carrinho.sessionbeans;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoBean implements Carrinho{
	private Set<String> produtos = new HashSet<String>();
	private static int contadorTotal;
	private static int contadorAtivos;
	private int id;

	@PostConstruct
	public void postConstruct(){
		synchronized (CarrinhoBean.class) {
			CarrinhoBean.contadorTotal++;
			CarrinhoBean.contadorAtivos++;
			this.id = CarrinhoBean.contadorTotal;

			System.out.println("PostConstruct");
			System.out.println("ID: " + this.id);
			System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
			System.out.println("ContadorAtivos: " + CarrinhoBean.contadorAtivos);
		}
	}
	@PreDestroy
	public void preDestroy() {
		synchronized (CarrinhoBean.class) {
			CarrinhoBean.contadorAtivos--;

			System.out.println("PreDestroy");
			System.out.println("ID: " + this.id);
			System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
			System.out.println("ContadorAtivos: " + CarrinhoBean.contadorAtivos);
		}
	}
	@PrePassivate
	public void prePassivate() {
		synchronized (CarrinhoBean.class) {
			CarrinhoBean.contadorAtivos--;

			System.out.println("PrePassivate");
			System.out.println("ID: " + this.id);
			System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
			System.out.println("ContadorAtivos: " + CarrinhoBean.contadorAtivos);
		}
	}
	@PostActivate
	public void postActivate() {
		synchronized (CarrinhoBean.class) {
			CarrinhoBean.contadorAtivos++;

			System.out.println("PostConstruct");
			System.out.println("ID: " + this.id);
			System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
			System.out.println("ContadorAtivos: " + CarrinhoBean.contadorAtivos);
		}

	}

	public void adiciona(String produto) {
		this.produtos.add(produto);
	}

	public void remove(String produto) {
		this.produtos.remove(produto);
	}

	public Set<String> getProdutos() {
		return produtos;
	}

	@Remove
	public void finalizaCompra() {
		//lógica para finalizar compra
	}

}
