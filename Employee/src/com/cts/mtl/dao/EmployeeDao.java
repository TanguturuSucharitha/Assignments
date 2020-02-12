package com.cts.mtl.dao;

import java.util.List;

import com.cts.mtl.exception.EmployeeDetailsException;
import com.cts.mtl.model.EmployeeDetails;

public interface EmployeeDao {
	
	String add(EmployeeDetails emp) throws EmployeeDetailsException;
	boolean delete(String id) throws EmployeeDetailsException;
	EmployeeDetails get(String id) throws EmployeeDetailsException;
	List<EmployeeDetails> getAll() throws EmployeeDetailsException;
	boolean update(EmployeeDetails emp) throws EmployeeDetailsException;
	void persist() throws EmployeeDetailsException;

}
