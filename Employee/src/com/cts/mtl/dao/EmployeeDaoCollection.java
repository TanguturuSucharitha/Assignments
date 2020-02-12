package com.cts.mtl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.mtl.exception.EmployeeDetailsException;
import com.cts.mtl.model.EmployeeDetails;

public class EmployeeDaoCollection implements EmployeeDao{
	
	private Map<String, EmployeeDetails> empDetails;
	
	public EmployeeDaoCollection() {
		
		empDetails=new TreeMap<>();
	}

	@Override
	public String add(EmployeeDetails emp) throws EmployeeDetailsException {
		String id = null;
		if (emp != null) {
			id = emp.getId();
			empDetails.put(id, emp);	
		}
		return id;
	}

	@Override
	public boolean delete(String id) throws EmployeeDetailsException {
		
		boolean isDone=false;
		if(id!=null) {
			
			empDetails.remove(id);
			isDone=true;
		}
		return isDone;
		
	}

	@Override
	public EmployeeDetails get(String id) throws EmployeeDetailsException {
		
		return empDetails.get(id);
		
	}

	@Override
	public List<EmployeeDetails> getAll() throws EmployeeDetailsException {
		
		return new ArrayList<>(empDetails.values());
	}

	@Override
	public boolean update(EmployeeDetails emp) throws EmployeeDetailsException {
		boolean isDone=false;
		
		if(emp!=null) {
			
			String id=emp.getId();
			empDetails.replace(id, emp);
		}
		return isDone;
	}

	@Override
	public void persist() throws EmployeeDetailsException {
		// TODO Auto-generated method stub
		
	}

}
