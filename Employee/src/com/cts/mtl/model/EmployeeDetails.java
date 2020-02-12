package com.cts.mtl.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeDetails implements Serializable {
	private String id;
	private String name;
	private int salary;
	private LocalDate doj;
	
	public EmployeeDetails() {
		// default constructor
	}
	
	public EmployeeDetails(String id,String name,int salary,LocalDate doj) {
		super();
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.doj=doj;
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		StringBuilder output=new StringBuilder("employee name:");
		output.append(name);
		output.append("\t id:");
		output.append(id);
		output.append("\t salary: ");
		output.append(salary);
		output.append("\t doj");
		output.append(doj);
		return output.toString();
	}
	
	

}
