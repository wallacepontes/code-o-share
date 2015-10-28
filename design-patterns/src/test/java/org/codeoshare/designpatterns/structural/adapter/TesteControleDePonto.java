package org.codeoshare.designpatterns.structural.adapter;

import org.codeoshare.designpatterns.structural.adapter.ControleDePonto;
import org.codeoshare.designpatterns.structural.adapter.ControleDePontoAdapter;
import org.codeoshare.designpatterns.structural.adapter.Funcionario;

public class TesteControleDePonto {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ControleDePonto controleDePonto = new ControleDePontoAdapter();
		Funcionario funcionario = new Funcionario("Wallace Pontes");
		
		controleDePonto.registraEntrada(funcionario);
		
		Thread.sleep(3000);
		
		controleDePonto.registraSaida(funcionario);

	}

}
