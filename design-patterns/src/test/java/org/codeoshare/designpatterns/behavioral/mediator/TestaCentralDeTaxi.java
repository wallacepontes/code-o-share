package org.codeoshare.designpatterns.behavioral.mediator;

public class TestaCentralDeTaxi {
    public static void main(String[] args) {
		CentralDeTaxi central = new CentralDeTaxi();
		
		Passageiro p1 = new Passageiro("Fulano", central);
		Passageiro p2 = new Passageiro("Sicrano", central);
		Passageiro p3 = new Passageiro("Beltrano", central);
		
		Taxi t1 = new Taxi(central);
		central.adicionaTaxiDisponivel(t1);
		
		Taxi t2 = new Taxi(central);
		central.adicionaTaxiDisponivel(t2);
		
		Taxi t3 = new Taxi(central);
		central.adicionaTaxiDisponivel(t3);

		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
	}
}
