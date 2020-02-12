package com.cts.mtl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
	
	private static ConnectionProvider instance;
	
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	
	public static final String JDBC_FILE_NAME="./res/jdbc.properties";
	
	private ConnectionProvider() throws IOException , FileNotFoundException {
		
		Properties propJdbc=new Properties();
		propJdbc.load(new FileInputStream(JDBC_FILE_NAME));
		
		dbUrl=propJdbc.getProperty("dburl");
		dbUserName=propJdbc.getProperty("dbunm");
		dbPassword=propJdbc.getProperty("dbpswd");
		
	}
	
	public Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
	}
	
	public static ConnectionProvider getInstance() throws FileNotFoundException, IOException {
		
		 if(instance==null)
			 instance=new ConnectionProvider();
		 return instance;
	}

}
