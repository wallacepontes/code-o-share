package org.codeoshare.jsf.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.codeoshare.jsf.model.entities.Carro;

@ManagedBean
@ApplicationScoped
public class CarrosBean {
    List<Carro> carros = new ArrayList<Carro>();
    private Carro carro = new Carro();

    public void adicionaCarro() {
    	this.carros.add(this.carro);
    	this.carro = new Carro();
    	FacesMessage mensagem = new FacesMessage("Turma adicionada");
    	FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}


}
