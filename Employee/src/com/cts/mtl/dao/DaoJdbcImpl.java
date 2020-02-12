package com.cts.mtl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.mtl.exception.EmployeeDetailsException;
import com.cts.mtl.model.EmployeeDetails;
import com.cts.mtl.util.ConnectionProvider;

public class DaoJdbcImpl implements EmployeeDao {
	
	ConnectionProvider conProvider;
	
	public DaoJdbcImpl() throws EmployeeDetailsException, ClassNotFoundException {
		// log = Logger.getLogger("dao");

		try {
			conProvider = ConnectionProvider.getInstance();
		} catch (IOException exp) {
			//log.error(exp);
			throw new EmployeeDetailsException("Database is not reachable");
		}
	}

	@Override
	public String add(EmployeeDetails emp) throws EmployeeDetailsException {
		
		String id=null;
		if(emp!=null) {
			
			try (Connection con = conProvider.getConnection();
					PreparedStatement pInsert = con.prepareStatement(IQueryMapper.ADD_EMP_QRY)){
				
				pInsert.setString(1,emp.getId());
				pInsert.setString(2,emp.getName());
				pInsert.setInt(3,emp.getSalary());
				pInsert.setDate(4, Date.valueOf(emp.getDoj()));
				
				int rowCount=pInsert.executeUpdate();
				
				if(rowCount==1) {
					id=emp.getId();
				}
				
			}catch(SQLException exp) {
				
				throw new EmployeeDetailsException("Employee details are not inserted" + exp);
			}
				
		}
		return id;
	}

	@Override
	public boolean delete(String id) throws EmployeeDetailsException {
		
		boolean isDone=false;
		
		try (Connection con = conProvider.getConnection();
				PreparedStatement pDelete = con.prepareStatement(IQueryMapper.DEL_EMP_QRY)){
			
			pDelete.setString(1,id);
			
			int rowCount=pDelete.executeUpdate();
			
			if(rowCount==1) {
				isDone=true;
			}
		}catch(SQLException exp) {
			
			throw new EmployeeDetailsException("employee not deleted");
		}
		return isDone;
	}

	@Override
	public EmployeeDetails get(String id) throws EmployeeDetailsException {
		
		EmployeeDetails emp=null;
		
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con.prepareStatement(IQueryMapper.GET_EMP_QRY)){
			
			pSelect.setString(1,id);
			
			ResultSet rs=pSelect.executeQuery();
			
			if(rs.next()) {
				
				emp=new EmployeeDetails();
				emp.setId(rs.getString("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDoj(rs.getDate("doj").toLocalDate());
			}
		}catch(SQLException exp) {
			
			throw new EmployeeDetailsException("employees not available");
		}
		return emp;
	}

	@Override
	public List<EmployeeDetails> getAll() throws EmployeeDetailsException {
		
		List<EmployeeDetails> emps=null;
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_ALL_EMP_QRY)) {

			ResultSet rs = pSelect.executeQuery();
			
			emps = new ArrayList<EmployeeDetails>();
			
			while(rs.next()){
				EmployeeDetails emp = new EmployeeDetails();
				emp.setId(rs.getString("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDoj(rs.getDate("doj").toLocalDate());
				emps.add(emp);
			}
			
		} catch (SQLException exp) {
			//log.error(exp);
			throw new EmployeeDetailsException("No Employees are available.");
		}		
		return emps;	
	}

	@Override
	public boolean update(EmployeeDetails emp) throws EmployeeDetailsException {
		
		boolean isDone=false;
		
		if(emp!=null) {
			
			try (Connection con = conProvider.getConnection();
					PreparedStatement pUpdate = con
							.prepareStatement(IQueryMapper.MODIFY_EMP_QRY)){
				
				pUpdate.setString(1,emp.getId());
				pUpdate.setInt(2,emp.getSalary());
				pUpdate.setString(3,emp.getId());
				
				int rowCount=pUpdate.executeUpdate();
				
				if(rowCount==1) {
					
					isDone=true;
					
				}
			}catch(SQLException exp) {
				
				throw new EmployeeDetailsException("employees are not available");
			}
		}
		return isDone;
		
	}

	@Override
	public void persist() throws EmployeeDetailsException {
		// TODO Auto-generated method stub
		
	}

}
