package org.codeoshare.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Caminho implements Trecho {
    List<Trecho> trechos = new ArrayList<>();
    
    public void adiciona(Trecho trecho) {
    	this.trechos.add(trecho);
    }
    public void remove(Trecho trecho) {
    	this.trechos.remove(trecho);
    }

	public void imprime() {
		for (Trecho trecho : this.trechos) {
			trecho.imprime();
		}
	}
}
