package com.client.ShoppersStack.GenericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con;
	Statement stat;
	
//connect to database....
public void getConnectToDatabase() throws SQLException, IOException
{
	FileUtility fLib= new FileUtility();
	Driver diver=new Driver();
	DriverManager.registerDriver(diver);
	con = DriverManager.getConnection(fLib.getDataFromProperty("dbUrl"), fLib.getDataFromProperty("dbUsername"), fLib.getDataFromProperty("dbPassword"));
	stat = con.createStatement();
}

//close database connection....
public void closeDbConnectioin() throws SQLException
{
	con.close();
}

//execute select query....
public ResultSet executeQuery(String query) throws SQLException
{
	ResultSet result = stat.executeQuery(query);
	return result;
}

//execute non select query
public int executeUpdate(String query) throws SQLException
{
	int result = stat.executeUpdate(query);
	return result;
}

//verify database....
public void verifyDatabase(String query,int colNum, String expectedValue) throws SQLException
{
	
	ResultSet result = stat.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String data = result.getString(colNum).toString();
		if(data.equals(expectedValue))
		{
			System.out.println(expectedValue+" is successfully verified : Passed");
			flag=true;
			break;
		}
	}
	if(flag==false)
	{
		System.out.println(expectedValue+" is not verified : Failed");
	}
}
}
