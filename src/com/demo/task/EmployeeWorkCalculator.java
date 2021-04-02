package com.demo.task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmployeeWorkCalculator {
	
	public void sortByProjectId(ArrayList<Task> tasks) {
		tasks.sort((t1,t2) ->  (int) (t1.getProjectId() - t2.getProjectId()));
	}
	
	public static long getTogetherWorkDays(Task task1, Task task2){
		if(task1.getProjectId() != task2.getProjectId()) {
			System.out.println("Logic error detected");
			return 0;
		}
		
		LocalDate beginDate = task1.getDateFrom().isBefore(task2.getDateFrom()) ? task2.getDateFrom() : task1.getDateFrom();
		LocalDate endDate = task1.getDateTo().isBefore(task2.getDateTo()) ? task1.getDateTo() : task2.getDateTo();
		
		//They dont work in the same day intervals
		if(endDate.isBefore(beginDate)) 
			return 0;
		 
		return ChronoUnit.DAYS.between(beginDate, endDate);
	}
	
	public void calculateLongestTeamwork(ArrayList<Task> tasks){
		sortByProjectId(tasks);
		List<EmployeePair> employeePairs = new ArrayList<EmployeePair>();
		
		for(int i = 0; i < tasks.size()-1; i++) {
			if(tasks.get(i).getProjectId() != tasks.get(i+1).getProjectId()) 
				continue;
			for(int j = i+1; j < tasks.size(); j++){
				if (tasks.get(i).getProjectId() != tasks.get(j).getProjectId())
					break;
				
				Task task1 = tasks.get(i);
				Task task2 = tasks.get(j);
				
				if (task1.getEmpId() == task2.getEmpId())
					continue;
				EmployeePair employeePair = new EmployeePair(task1.getEmpId(),task2.getEmpId());
				
				// Calculate days work 
				long days = getTogetherWorkDays(task1, task2);
					if(days <=0)
						continue;
					
				// Check if employee pair exists in array
				int index = employeePairs.indexOf(employeePair);
				if( index < 0) {
					employeePair.setWorkTogether(days);
					employeePairs.add(employeePair);
				}else {
					employeePairs.get(index).addWorkDays(days);
				}
			}
		}
		
		employeePairs.sort((e1,e2) -> (int) (e2.getWorkTogether()-e1.getWorkTogether()));
		
		if(employeePairs.size() <= 0)
			System.out.println("No matches");
		else
			System.out.println(employeePairs.get(0));
		
	}
	
	public ArrayList<Task> getTasksArray(String textFileName) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		try {

			BufferedReader sc = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(textFileName), "UTF-8"));
			
			while(sc.ready()) {
				tasks.add(new Task(sc.readLine()));
			}
			
			sc.close();

		}catch(Exception e ) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	public void calculateFromFile(String fileName) {
		ArrayList<Task> tasks = getTasksArray(fileName);
		calculateLongestTeamwork(tasks);
	}

}