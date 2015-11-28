package org.codeoshare.dado;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

public class Lancador implements Runnable {

	private String id;
	private CentralDeLance central;
	private LancadorDeDado lancadorDeDado;

	public Lancador(String id, CentralDeLance central, LancadorDeDado lancadorDeDado) {
		this.id = id;
		this.central = central;
		this.lancadorDeDado = lancadorDeDado;
	}

	public String getId() {
		return this.id;
	}

	public LancadorDeDado getLancadorDeDado() {
		return this.lancadorDeDado;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.central.lanca(this);
		}

	}


}
