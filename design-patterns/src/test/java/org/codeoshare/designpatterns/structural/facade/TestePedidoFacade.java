package org.codeoshare.designpatterns.structural.facade;

import org.codeoshare.designpatterns.structural.facade.Estoque;
import org.codeoshare.designpatterns.structural.facade.Financeiro;
import org.codeoshare.designpatterns.structural.facade.Pedido;
import org.codeoshare.designpatterns.structural.facade.PedidoFacade;
import org.codeoshare.designpatterns.structural.facade.PosVenda;

public class TestePedidoFacade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Estoque estoque = new Estoque();
		Financeiro financeiro = new Financeiro();
		PosVenda posVenda = new PosVenda();
		
		PedidoFacade facade = new PedidoFacade(estoque, financeiro, posVenda);
		
		Pedido pedido = new Pedido("Notebook", "Wallace", "Rua Aroazes");
		
		facade.registraPedido(pedido);

	}

}
