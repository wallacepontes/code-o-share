package org.codeoshare.designpatterns.structural.flyweight;

public class Slide {
    private TemaFlyweight tema;
    private String titulo;
    private String texto;
	
    public Slide(TemaFlyweight tema, String titulo, String texto) {
		super();
		this.tema = tema;
		this.titulo = titulo;
		this.texto = texto;
	}
    
    public void imprime() {
    	this.tema.imprime(titulo, texto);
    }
}
