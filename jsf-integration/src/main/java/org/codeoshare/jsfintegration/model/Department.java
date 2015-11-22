package org.codeoshare.jsfintegration.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cos_department")
public class Department {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany
	@JoinTable(name="cos_dep_empl",
	  joinColumns=@JoinColumn(name="DEP_ID"),
	  inverseJoinColumns=@JoinColumn(name="EMP_ID"))
	private Collection<Employee> employee = new ArrayList<Employee>();

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

	public Collection<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Collection<Employee> employee) {
		this.employee = employee;
	}
}
