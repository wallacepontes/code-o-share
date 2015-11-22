package org.codeoshare.jsfintegration.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.codeoshare.jsfintegration.model.Car;
import org.codeoshare.jsfintegration.model.CarRepository;

@ManagedBean
public class CarBean {
    private Car car = new Car();
    
    private List<Car> cars;
    
    public void addCar() {
    	EntityManager manager = this.getEntityManager();
    	CarRepository repository = new CarRepository(manager);
    	repository.addCar(this.car);
    	this.car = new Car();
    	this.cars = null;
    }
    public List<Car> getCars() {
    	if (this.cars == null) {
    	EntityManager manager = this.getEntityManager();
    	CarRepository repository = new CarRepository(manager);
    	this.cars = repository.getAll();
    	}
    	return this.cars;
    }
    public EntityManager getEntityManager() {
    	FacesContext fc = FacesContext.getCurrentInstance();
    	ExternalContext ec = fc.getExternalContext();
    	HttpServletRequest request = (HttpServletRequest) ec.getRequest();
    	EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
    	
    	return manager;
    }
    // GETTERS E SETTERS
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
}
