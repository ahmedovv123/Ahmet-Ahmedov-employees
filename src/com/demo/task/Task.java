package com.demo.task;

import java.time.LocalDate;

public class Task {

	private long empId;
	private long projectId;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	public Task(String line) {
		String result = line.replaceAll("\\s+", "");
		String[] tokens = result.split(",");
		
		this.empId = Long.parseLong(tokens[0]);
		this.projectId = Long.parseLong(tokens[1]);
		this.dateFrom = LocalDate.parse(tokens[2]);
		
		if(tokens[3].equals("NULL")) {
			 this.dateTo = LocalDate.now();
		}else {
			 this.dateTo = LocalDate.parse(tokens[3]);
		}
	}
	
	public Task(Long empId, Long projectId, LocalDate dateFrom, LocalDate dateTo) {
		this.empId = empId;
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

}
