package com.cts.mtl.dao;

public class IQueryMapper {
	
	public static final String ADD_EMP_QRY="insert into "
			    + "                         employee(id,name,salary,doj) "
			    + "                         values(?,?,?,?)";
	
	public static final String DEL_EMP_QRY="delete from "
			+ "                             employee "
			+ "                             where id=?";
	
	public static final String MODIFY_EMP_QRY="update employee "
			+ "                             set name=?,salary=?"
			+ "                             where id=?";
	
	public static final String GET_ALL_EMP_QRY="select *"
			+ "                                 from employee";
	
	public static final String GET_EMP_QRY="select *"
			+ "                             from employee"
			+ "                             where id=?";

}
