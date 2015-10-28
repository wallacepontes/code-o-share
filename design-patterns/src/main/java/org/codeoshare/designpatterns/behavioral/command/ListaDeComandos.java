package org.codeoshare.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;


public class ListaDeComandos {
    private List<Comando> comandos = new ArrayList<>();
    
    public void adiciona(Comando comando) {
    	this.comandos.add(comando);
    }
    
    public void executa() {
    	for( Comando comando : this.comandos) {
    		comando.execute();
    	}
    }
}
