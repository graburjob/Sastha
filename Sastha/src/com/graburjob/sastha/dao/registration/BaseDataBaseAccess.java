package com.graburjob.sastha.dao.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDataBaseAccess {
	
	public Connection getDBConnection(){
	    String driverName = "com.mysql.jdbc.Driver";
	    Connection connection= null;
	    try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    String serverName = "localhost";
	    String mydatabase = "sastha";
	    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
	                                                                    
	    String username = "sastha";
	    String password = "sastha";
	    try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return connection; 
	}

}
