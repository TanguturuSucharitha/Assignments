package com.cts.jdbcd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListOfEmployees {

	public static void main(String[] args) {
		try (
				Scanner scan = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","welcome");
			) {
		
			PreparedStatement ps = con.prepareStatement("select department_id,COUNT(*) as count from employees group by department_id");
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.printf("%-15s%-40s\n", rs.getString("job_id"), rs.getString("job_title"));
			}
			
			
		} catch (SQLException e) {
			System.err.println("Could not retrieve.");
			e.printStackTrace();
		} 

	}

}
