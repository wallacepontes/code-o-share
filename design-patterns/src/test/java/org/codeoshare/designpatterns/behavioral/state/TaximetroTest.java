package org.codeoshare.designpatterns.behavioral.state;

import static org.junit.Assert.*;
import org.junit.Test;

public class TaximetroTest {

	@Test
	public void testState() throws Exception {
		Bandeira b1 = new Bandeira1();
		Bandeira b2 = new Bandeira2();

		Taximetro taximetro = new Taximetro(b1);
		
		
		double valor1 = taximetro.calculaValorDaCorrida(10, 20);
		System.out.println("Valor da corrida em bandeira 1: " + valor1);
		
		assertEquals(54.0, valor1, 1);
		
		taximetro.setBandeira(b2);
		
		double valor2 = taximetro.calculaValorDaCorrida(5, 30);
		System.out.println("Valor da corrida em bandeira 2: "+ valor2);
		
		assertEquals(145.0, valor2, 1);
	}
}
