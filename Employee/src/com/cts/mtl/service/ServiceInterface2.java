package com.cts.mtl.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cts.mtl.dao.DaoJdbcImpl;
import com.cts.mtl.dao.EmployeeDao;
import com.cts.mtl.dao.EmployeeStreamImpl;
import com.cts.mtl.exception.EmployeeDetailsException;
import com.cts.mtl.model.EmployeeDetails;

public class ServiceInterface2 implements ServiceInterface {
	
	private EmployeeDao empdao;
	
	public EmployeeDao getDao() {
	       return empdao;
		 
	}
	
	public ServiceInterface2() throws EmployeeDetailsException, ClassNotFoundException {
		//empdao=new EmployeeStreamImpl();
		empdao=new DaoJdbcImpl();
		
	}
	
	public boolean isValidId(String id) {
		
		Pattern idPattern = Pattern.compile("[A-Z]\\d{1}");
		Matcher idMatcher = idPattern.matcher(id);
		
		return idMatcher.matches();
	}
	
	public boolean isValidName(String name) {
		
		Pattern namePattern=Pattern.compile("[a-z]{6}");
		Matcher nameMatcher=namePattern.matcher(name);
		
		return nameMatcher.matches();
	}
	
	public boolean  isValidSalary(int salary) {
		
		return salary>=1000 && salary<=40000;
	}
	
	public boolean isValidDoj(LocalDate doj) {
		
		LocalDate today = LocalDate.now();
		return today.isAfter(doj) || doj.equals(today);
		
	}
	
	public boolean isValidEmployeeDetails(EmployeeDetails emp) throws EmployeeDetailsException{
		
		boolean isValid=false;
		
		List<String> errmsgs=new ArrayList<>();
		if(!isValidId(emp.getId())) {
			errmsgs.add("id must starts with capital letter followed by digit");
		}
		
		if(!isValidName(emp.getName())) {
			errmsgs.add("name should starts  characters. ");
		}
		
		if(!isValidSalary(emp.getSalary())) {
			errmsgs.add("salary must be greater than 1000 and less than 40000");
		}
		
		if(!isValidDoj(emp.getDoj())) {
			errmsgs.add("enter correct date of joining");
		}
		
		if(errmsgs.size()==0)
			isValid=true;
		else
			throw new EmployeeDetailsException(errmsgs.toString());
		
		return isValid;
	}

	@Override
	public String add(EmployeeDetails emp) throws EmployeeDetailsException {
		String id=null;
		if(emp!=null && isValidEmployeeDetails(emp)){
			id=empdao.add(emp);
		}
		return id;
	
	}

	@Override
	public boolean delete(String id) throws EmployeeDetailsException {
		boolean isDone=false;
		
		if(id!=null && isValidId(id)){
			empdao.delete(id);
			isDone = true;
		}else{
			throw new EmployeeDetailsException("id should be a capital letter followed by 1 digits");
		}
		return isDone;
	}

	@Override
	public EmployeeDetails get(String id) throws EmployeeDetailsException {
		
		return empdao.get(id);
	}

	@Override
	public List<EmployeeDetails> getAll() throws EmployeeDetailsException {
		
		return empdao.getAll();
	}

	@Override
	public boolean update(EmployeeDetails emp) throws EmployeeDetailsException {
		
		boolean isDone=false;
		if(emp!=null && isValidEmployeeDetails(emp)) {
			
			isDone=empdao.update(emp);
			
		}
		
		return isDone;
		
	}

	@Override
	public void persist() throws EmployeeDetailsException {
		empdao.persist();
		
	}

}
