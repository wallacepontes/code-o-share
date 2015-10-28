package org.codeoshare.designpatterns.creational.builder;

import java.util.Calendar;

public class GeradorDeBoleto {
    private BoletoBuilder boletoBuilder;
    
	public GeradorDeBoleto(BoletoBuilder boletoBuilder) {
		this.boletoBuilder = boletoBuilder;
	}
	
	public Boleto geraBoleto() {
		String sacado = "NomeDaPessoaQueEfetuaPagamento";
		this.boletoBuilder.buildSacado(sacado);
		String cedente = "NomeDaPessoaQueRecebePagamento";
		this.boletoBuilder.buildCedente(cedente);
		double valor = 1000;
		this.boletoBuilder.buildValor(valor);
		Calendar vencimento = Calendar.getInstance();
		vencimento.add(Calendar.DATE, 30);
		this.boletoBuilder.buildVencimento(vencimento);
		this.boletoBuilder.buildNossoNumero(1234);
		
		this.boletoBuilder.buildCodigoDeBarra();
		this.boletoBuilder.buildLogotipo();
		
		return this.boletoBuilder.getBoleto();
	}
}
