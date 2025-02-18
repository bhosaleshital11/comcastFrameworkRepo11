package com.ClientName.AppName.GenericUtility.dataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ClientName.AppName.GenericUtility.FiLeUtility.FileUtility;
import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn=null;
	Statement st=null;
public void getConnetiToDatabase() throws Throwable
{
	try {
	Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		FileUtility fu=new FileUtility();
		String DBURL=fu.getDataFromProperties("dbUrl");
		String DBUSERNAME=fu.getDataFromProperties("dbUserName");
		String DBUBDPASSWORDRL=fu.getDataFromProperties("dbPassword");
		conn=DriverManager.getConnection(DBURL,DBUSERNAME,DBUBDPASSWORDRL);
	}
	catch(Exception e){	
	}
}
	public void closeDatabaseConnection() 
	{
		try {
			conn.close();
		}
		catch(Exception e) {
}
}
	public ResultSet executeSelectQuery(String query) throws Throwable
	{
		ResultSet result = null;
	
		try {
		Statement statement = conn.createStatement();
		 result = statement.executeQuery(query);
		  
		}
		catch(Exception e)
		{
		
		}
		return result;
	}
	
	public int executeUpdateQuery(String query) throws Throwable {
		int result=(Integer) null;
		try {
		Statement statement = conn.createStatement();
		 result = statement.executeUpdate(query);
	}
		catch(Exception e) {
		}	
		return result;
		
	}
}

