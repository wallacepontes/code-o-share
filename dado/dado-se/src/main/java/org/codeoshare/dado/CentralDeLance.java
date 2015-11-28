package org.codeoshare.dado;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.codeoshare.dado.sessionbeans.LancadorDeDado;

public class CentralDeLance {
    List<Lancador> lancadorEmEspera = new ArrayList<>();
    boolean espera;

    public CentralDeLance() {
    	this.espera = true;
	}

	public synchronized void iniciaLances() {
    	System.out.println("TOTAL DE LANCADORES : " + lancadorEmEspera.size());
    	this.espera = false;
    	this.notifyAll();
    }


    public int lanca(Lancador lancador) {
    	this.lancadorEmEspera.add(lancador);

    	synchronized (this) {
    		while (espera) {
	            try {
				    System.out.println("Espera Lancador " + lancador.getId());
				    this.wait();
			    } catch (InterruptedException e) {
				    e.printStackTrace();
			    }
    		}
			int resultado = lancador.getLancadorDeDado().lanca();
			System.out.println("L(" + lancador.getId() + ") = " + resultado);

			return resultado;
		}
    }

    public void setEspera(boolean espera) {
		this.espera = espera;
	}

	public int totalDeLancadores() {
    	return this.lancadorEmEspera.size();
    }

}
