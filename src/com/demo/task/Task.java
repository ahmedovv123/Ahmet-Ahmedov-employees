package com.demo.task;

import java.time.LocalDate;

/**
 * 
 * Class for handling tasks from the text file.
 * 
 * @author Ahmet Ahmedov
 *
 */

public class Task {
	
	//Variable for employee ID
	private long empId;
	
	//Variable for project ID
	private long projectId;
	
	//Variable for starting date on project
	private LocalDate dateFrom;
	
	//variable from finishing date on project
	private LocalDate dateTo;
	
	//Creating new object of Task from a single line from text file.
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
	
	//Constructor
	public Task(Long empId, Long projectId, LocalDate dateFrom, LocalDate dateTo) {
		this.empId = empId;
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	//Getters and setters.
	
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
