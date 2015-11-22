package org.codeoshare.jsfintegration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="cos_product")
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Double price;
	
	@PrePersist
	public void prePersist(){
		System.err.println("Persist a new object with persist() or merge()");
	}
	
	@PostPersist
	public void posPersist(){
		System.out.println("The command insert was excuted into BD.");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
