package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	public static Connection getConnection() { //import Connection from java.sql only
		Connection c= null;
		try {
			//classname and url will be obtained from drver documentation
			Class.forName("com.mysql.jdbc.Driver"); //loads the driver class
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "visa", "secret");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return c;
		
	}

}
