package com.demo.task;

public class EmployeePair {

	private long employee1;
	private long employee2;
	private long workTogether;
	
	
	
	public EmployeePair(long employee1, long employee2) {
		this.employee1 = employee1;
		this.employee2 = employee2;
		this.workTogether = 0;
	}
	
	public long getWorkTogether() {
		return workTogether;
	}
	public void setWorkTogether(long workTogether) {
		this.workTogether = workTogether;
	}
	public long getEmployee1() {
		return employee1;
	}
	public void setEmployee1(long employee1) {
		this.employee1 = employee1;
	}
	public long getEmployee2() {
		return employee2;
	}
	public void setEmployee2(long employee2) {
		this.employee2 = employee2;
	}

	public void addWorkDays(long days) {
		this.workTogether += days;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employee1 ^ (employee1 >>> 32));
		result = prime * result + (int) (employee2 ^ (employee2 >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePair other = (EmployeePair) obj;
		if( (employee1 == other.employee1 && employee2 == other.employee2) 
				|| (employee1 == other.employee2 && employee2 == other.employee1)) 
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		return "Employees with id " + employee1 + " and " + employee2 + " worked together for " + workTogether + " days.";  
	}
	
	
	
}
