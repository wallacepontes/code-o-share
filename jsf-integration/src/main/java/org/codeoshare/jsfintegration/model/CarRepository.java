package org.codeoshare.jsfintegration.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CarRepository {
    private EntityManager manager;
    
    public CarRepository(EntityManager manager) {
    	this.manager = manager;
    }
    public void addCar(Car car) {
    	this.manager.persist(car);
    }
    public List<Car> getAll() {
    	Query query = this.manager.createQuery("Select x from Car x");
    	return query.getResultList();
    }
}
