package org.codeoshare.designpatterns.structural.facade;

public class PedidoFacade {

	private Estoque estoque;
	private Financeiro financeiro;
	private PosVenda posvenda;
	public PedidoFacade(Estoque estoque, Financeiro financeiro,
			PosVenda posvenda) {
		this.estoque = estoque;
		this.financeiro = financeiro;
		this.posvenda = posvenda;
	}
	
	public void registraPedido(Pedido pedido) {
		this.estoque.enviaProduto(pedido.getProduto(), pedido.getEnderecoDeEntrega());
		this.financeiro.fatura(pedido.getCliente(), pedido.getProduto());
		this.posvenda.agendaContato(pedido.getCliente(), pedido.getProduto());
		
	}
	

}
