package com.cts.mtl.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.mtl.exception.EmployeeDetailsException;
import com.cts.mtl.model.EmployeeDetails;

   public class EmployeeStreamImpl implements EmployeeDao {
	
	public static final String DATA_STORE_FILE_NAME = "employee                                                               .dat";
	
    private Map<String, EmployeeDetails> empDetails;
	
	public EmployeeStreamImpl() throws EmployeeDetailsException {
		
		File file = new File(DATA_STORE_FILE_NAME);
		
		//empDetails=new TreeMap<>();
		
		if (!file.exists()) {
			empDetails = new TreeMap<>();
		} else {
			try (ObjectInputStream fin = new ObjectInputStream(
					new FileInputStream(DATA_STORE_FILE_NAME))) {

				Object obj = fin.readObject();

				if (obj instanceof Map) {
					empDetails = (Map<String, EmployeeDetails>) obj;
				} else {
					throw new EmployeeDetailsException("Not a valid DataStore");
				}
			} catch (IOException | ClassNotFoundException exp) {
				throw new EmployeeDetailsException("Loading Data Failed");
			}
		}
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
		try (ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream(DATA_STORE_FILE_NAME))) {
			fout.writeObject(empDetails);
		} catch (IOException exp) {
			throw new EmployeeDetailsException("Saving Data Failed");
		}
	}

}
