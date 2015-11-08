package org.codeoshare.designpatterns.creational.objectpool;

import java.util.ArrayList;
import java.util.List;

public class SalaPool implements Pool<Sala> {

	private List<Sala> salas;
	
	public SalaPool() {
		this.salas = new ArrayList<Sala>();
		this.salas.add(new Sala("F1"));
		this.salas.add(new Sala("S2"));
		this.salas.add(new Sala("B3"));
	}

	public Sala acquire() {
		if (this.salas.size() > 0) {
			return this.salas.remove(0);
		} else {
			return null;
		}
	}

	public void release(Sala sala) {
		this.salas.add(sala);
	}
}
