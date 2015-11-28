package org.codeoshare.dado;

import java.util.Scanner;

import javax.naming.InitialContext;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

public class LancadorTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Contactando central...");
		CentralDeLance central = new CentralDeLance();
    	InitialContext ic = new InitialContext();



		for (int i = 0; i < 1000; i++) {
			final LancadorDeDado lancadorDeDado = (LancadorDeDado) ic.lookup("java:global/dado-war/LancadorDeDadoBean");
			//System.out.println("Lancador - " + i);

			double random = Math.random();
			String id = String.valueOf(random).substring(2);

			Lancador lancador = new Lancador(id, central, lancadorDeDado);
			new Thread(lancador).start();

		}

		System.out.println("Tecle algo para iniciar");
		String algo = entrada.nextLine();

		if (!algo.equals("n")) {
			central.iniciaLances();
		}

		System.out.println("Fim");

	}

}
