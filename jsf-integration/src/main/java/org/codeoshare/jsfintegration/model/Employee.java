package org.codeoshare.jsfintegration.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cos_employee")
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(
			name="cos_employee_phones",
			joinColumns=@JoinColumn(name="emp_id"))
	@Column(name="phone")
	private Collection<String> phones;
	
	@ManyToOne
	@JoinColumn(name="dep_id")
	private Department department;

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

	public Collection<String> getPhones() {
		return phones;
	}

	public void setPhones(Collection<String> phones) {
		this.phones = phones;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
