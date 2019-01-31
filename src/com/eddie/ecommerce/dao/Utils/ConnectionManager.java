package com.eddie.ecommerce.dao.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager	 {


	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://10.53.124.212:3306/powergaming?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true"
			+ "&useLegacyDatetimeCode=false&serverTimezone=UTC";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	static {

		try {
			// Carga el driver directamente, sin pool 
			 Class.forName(JDBC_DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
//			logger.fatal(e.getMessage(), e); 
		}

	}

	private ConnectionManager() {}

	public final static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
}