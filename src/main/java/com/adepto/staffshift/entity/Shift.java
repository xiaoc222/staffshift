package com.adepto.staffshift.entity;

public class Shift {

	private int shiftID;
	private String day;
	private String requiredRole;
	private int hours;
	private int employeeID;

	public int getShiftID() {
		return shiftID;
	}

	public void setShiftID(int shiftID) {
		this.shiftID = shiftID;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRequiredRole() {
		return requiredRole;
	}

	public void setRequiredRole(String requiredRole) {
		this.requiredRole = requiredRole;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Shift [shiftID=" + shiftID + ", day=" + day + ", requiredRole=" + requiredRole + ", hours=" + hours
				+ ", employeeID=" + employeeID + "]";
	}

}
