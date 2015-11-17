package org.codeoshare.jsf.controller.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.codeoshare.jsf.model.entities.Estado;

@ManagedBean
@SessionScoped
public class EstadoBean {
    private String nome;
    private String cidade;
    private String estado;

    private Estado estadoSelecionado = new Estado();
    private List<Estado> estados = new ArrayList<Estado>();

    public EstadoBean() {
    	Estado sp = new Estado();
    	sp.setSigla("SP");
    	sp.setNome("São Paulo");
    	sp.getCidades().add("São Paulo");
    	sp.getCidades().add("Campinas");

    	Estado rj = new Estado();
    	rj.setSigla("RJ");
    	rj.setNome("Rio de Janeiro");
    	rj.getCidades().add("Rio de Janeiro");
    	rj.getCidades().add("Niterói");

    	Estado ce = new Estado();
    	ce.setSigla("CE");
    	ce.setNome("Ceará");
    	ce.getCidades().add("Fortaleza");
    	ce.getCidades().add("Canoa");

    	this.estados.add(sp);
    	this.estados.add(rj);
    	this.estados.add(ce);
    }
    public void mudaEstado(ValueChangeEvent event) {
    	this.estado = event.getNewValue().toString();
    	for (Estado e : this.estados) {
			if (e.getSigla().equals(this.estado)) {
				this.estadoSelecionado = e;
				break;
			}
		}
    	FacesContext.getCurrentInstance().renderResponse();
    }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}
	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
