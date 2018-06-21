package com.DAOService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.DAOInterface.DAOInterface;
import com.provider.Connect;

public class Psngr implements DAOInterface
{
	
	public int insert(String u, String p) 		//Method to insert values in a table
	{
		try
		{
			Connection con;							//Connection Variable
			PreparedStatement stmt;					//ResultSet variable to return result set
			con=Connect.connectionProvider();		//Obtaining Connection
			stmt=con.prepareStatement("insert into Passenger(pName, pPass) values(?, ?)");	//Writing query 
			stmt.setString(1, u);					//Setting values according to positions of ? marks
			stmt.setString(2, p);
			stmt.executeUpdate();					//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet search() 	//Method to return ResultSet carrying the reference to the table
	{	
		Connection con;			//Connection Variable
		ResultSet rs = null;	//ResultSet variable to return result set
		Statement stmt;			//Statement variable to execute a static query
		try
		{
			con=Connect.connectionProvider();					//Obtaining Connection
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Passenger");	//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;				//Returning Result set
	}
		
}
