package org.codeoshare.designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Apresentacao {
    List<Slide> slides = new ArrayList<>();
    
    public void adicionaSlide(Slide slide) {
    	slides.add(slide);
    }
    
    public void imprime() {
    	for (Slide slide : this.slides) {
    		slide.imprime();
    		System.out.println();
    	}
    }
}
