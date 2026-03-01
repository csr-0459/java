package com.Shopping.XYZ.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection {
	
	private static final String DB_HOST="com.mysql.cj.jdbc.Driver";
	private static final String DRIVER_NAME="jdbc:mysql://localhost:3306/shopping";
	private static final String USER_NAME="root";
	private static final String PASSWORD="asdf";
	
	
	public static Connection getDataBaseConnection()
	{
		try
		{
			Class.forName(DB_HOST);
			return DriverManager.getConnection(DRIVER_NAME,USER_NAME,PASSWORD);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

}
