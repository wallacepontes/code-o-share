package org.codeoshare.designpatterns.creational.builder;

import static org.junit.Assert.*;
import org.junit.Test;

public class GeradorDeBoletoTest {
	
	@Test
	public void testBuilder() throws Exception {
        BoletoBuilder boletoBuilder = new BBBoletoBuilder();
        GeradorDeBoleto geradorDeBoleto = new GeradorDeBoleto(boletoBuilder);
        Boleto boleto = geradorDeBoleto.geraBoleto();
        System.out.println(boleto);
        
        assertNotNull(boleto);
	}
}
