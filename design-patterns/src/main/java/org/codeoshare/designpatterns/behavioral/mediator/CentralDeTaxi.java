package org.codeoshare.designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class CentralDeTaxi {
    List<Passageiro> passageirosEmEspera = new ArrayList<>();
    List<Taxi> taxisLivres = new ArrayList<>();
    
    public synchronized void adicionaTaxiDisponivel(Taxi taxi) {
    	System.out.println("Taxi " + taxi.getId() + " voltou para fila.");
    	taxisLivres.add(taxi);
    	this.notifyAll();
    }
    public void pedeTaxi(Passageiro passageiro) {
    	Taxi taxi = this.esperaTaxi(passageiro);
    	System.out.println("Taxi " + taxi.getId() + " levando " + passageiro.getNome());
    	taxi.atende();
    }
    
    public Taxi esperaTaxi(Passageiro passageiro) {
    	this.passageirosEmEspera.add(passageiro);
    	synchronized (this) {
			while (this.taxisLivres.isEmpty() || 
					!this.passageirosEmEspera.get(0).equals(passageiro)) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.passageirosEmEspera.remove(0);
			return this.taxisLivres.remove(0);
		}
    }
}

