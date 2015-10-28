package org.codeoshare.designpatterns.behavioral.state;

public class Taximetro {
    private Bandeira bandeira;

	public Taximetro(Bandeira bandeira) {
		super();
		this.bandeira = bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
    
    public double calculaValorDaCorrida(double tempo, double distancia) {
    	return this.bandeira.calculaValorDaCorrida(tempo, distancia);
    }
}
