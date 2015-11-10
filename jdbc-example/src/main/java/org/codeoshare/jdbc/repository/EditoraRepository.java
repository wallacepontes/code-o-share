package org.codeoshare.jdbc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.codeoshare.jdbc.entities.Editora;

public class EditoraRepository {
    private EntityManager manager;

	public EditoraRepository(EntityManager manager) {
		this.manager = manager;
	}
    
    public void adiciona(Editora editora) {
    	this.manager.persist(editora);
    }
    
    public Editora busca(Long id){
    	return this.manager.find(Editora.class, id);
    }
    
    public List<Editora> buscaTodas(){
    	Query query = this.manager.createQuery("SELECT e FROM Editora e");
    	return query.getResultList();
    }
}
