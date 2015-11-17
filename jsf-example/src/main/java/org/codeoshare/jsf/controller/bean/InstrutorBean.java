package org.codeoshare.jsf.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.codeoshare.jsf.model.entities.Instrutor;


@ManagedBean
public class InstrutorBean {
    private List<Instrutor> instrutores = new ArrayList<Instrutor>();

    public InstrutorBean() {
    	Instrutor fulano = new Instrutor();
    	fulano.setNome("Beltrano S");
    	fulano.setDataDeNascimento("21/06/1953");

    	Instrutor sicrano = new Instrutor();
    	sicrano.setNome("Sicrano B");
    	sicrano.setDataDeNascimento("12/01/1986");

    	this.instrutores.add(fulano);
    	this.instrutores.add(sicrano);
    }

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}

}
