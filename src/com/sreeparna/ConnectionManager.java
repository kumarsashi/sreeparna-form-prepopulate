package com.sreeparna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionManager {
	
	private static Connection con;
	
	public static Connection getConnection() throws SQLException {
		
	
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "root"); 
	    
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    // loads mysql driver

	    return con;
	}
}
