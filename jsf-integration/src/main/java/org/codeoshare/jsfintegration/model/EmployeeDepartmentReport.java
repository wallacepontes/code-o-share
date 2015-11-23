package org.codeoshare.jsfintegration.model;

public class EmployeeDepartmentReport {
	private String employee;
	private String department;
	
	public EmployeeDepartmentReport(String employee, String department) {
		super();
		this.employee = employee;
		this.department = department;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
