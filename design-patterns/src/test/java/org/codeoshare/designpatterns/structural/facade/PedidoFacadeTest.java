package org.codeoshare.designpatterns.structural.facade;

import org.codeoshare.designpatterns.structural.facade.Estoque;
import org.codeoshare.designpatterns.structural.facade.Financeiro;
import org.codeoshare.designpatterns.structural.facade.Pedido;
import org.codeoshare.designpatterns.structural.facade.PedidoFacade;
import org.codeoshare.designpatterns.structural.facade.PosVenda;

import static org.junit.Assert.*;
import org.junit.Test;

public class PedidoFacadeTest {

	@Test
	public void testFacade() throws Exception {
		Estoque estoque = new Estoque();
		Financeiro financeiro = new Financeiro();
		PosVenda posVenda = new PosVenda();
		
		PedidoFacade facade = new PedidoFacade(estoque, financeiro, posVenda);
		
		Pedido pedido = new Pedido("Notebook", "Fulano", "Rua Sicrano Beltrano");
		
		facade.registraPedido(pedido);
		
		assertTrue(true);
	}
}
