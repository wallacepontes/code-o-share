package org.codeoshare.designpatterns.creational.builder;

public class TestaBBBoletoBuilder {
	public static void main(String[] args) {
        BoletoBuilder boletoBuilder = new BBBoletoBuilder();
        GeradorDeBoleto geradorDeBoleto = new GeradorDeBoleto(boletoBuilder);
        Boleto boleto = geradorDeBoleto.geraBoleto();
        System.out.println(boleto);
	}
}
