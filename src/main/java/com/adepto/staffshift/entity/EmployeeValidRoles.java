package com.adepto.staffshift.entity;

public class EmployeeValidRoles {

	private int employeeID;
	private String role;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EmployeeValidRoles [employeeID=" + employeeID + ", role=" + role + "]";
	}

}
