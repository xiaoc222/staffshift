package com.adepto.staffshift.entity;

public class EmployeeDaysUnavailable {

	private int employeeID;
	private String daysUnavailable;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getDaysUnavailable() {
		return daysUnavailable;
	}

	public void setDaysUnavailable(String daysUnavailable) {
		this.daysUnavailable = daysUnavailable;
	}

	@Override
	public String toString() {
		return "EmployeeDaysUnavailable [employeeID=" + employeeID + ", daysUnavailable=" + daysUnavailable + "]";
	}

}
