package org.codeoshare.designpatterns.structural.composite;

public class TrechoDeOnibus implements Trecho {
	private String direcao;
    private double distancia;
    
    public TrechoDeOnibus(String direcao, double distancia) {
    	this.direcao = direcao;
    	this.distancia = distancia;
    }

	public void imprime() {
		System.out.println("Vá de Ónibus: ");
		System.out.println(this.direcao);
		System.out.println("A distância percorrida será de: " + this.distancia + " metros.");

	}
}
