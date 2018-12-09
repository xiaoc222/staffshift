package com.adepto.staffshift.entity;

public class EmployeeMaxhours {

	private int employeeID;
	private int maxHours;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getMaxHours() {
		return maxHours;
	}

	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}

	@Override
	public String toString() {
		return "EmployeeMaxhours [employeeID=" + employeeID + ", maxHours=" + maxHours + "]";
	}

}
