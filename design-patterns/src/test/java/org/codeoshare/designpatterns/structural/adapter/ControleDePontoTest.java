package org.codeoshare.designpatterns.structural.adapter;

import org.codeoshare.designpatterns.structural.adapter.ControleDePonto;
import org.codeoshare.designpatterns.structural.adapter.ControleDePontoAdapter;
import org.codeoshare.designpatterns.structural.adapter.Funcionario;

import static org.junit.Assert.*;
import org.junit.Test;

public class ControleDePontoTest {

	@Test
	public void testAdapter() throws Exception {
		ControleDePonto controleDePonto = new ControleDePontoAdapter();
		Funcionario funcionario = new Funcionario("Fulano");
		
		controleDePonto.registraEntrada(funcionario);
		
		Thread.sleep(3000);
		
		controleDePonto.registraSaida(funcionario);
		
		assertTrue(true);
	}
}
