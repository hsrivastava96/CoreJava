package com.DAOService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.DAOInterface.TransInterface;
import com.exceptions.InvalidTrainId;
import com.provider.Connect;

public class Trn implements TransInterface
{

	public ResultSet search() 	//Method to return ResultSet carrying the reference to the table
	{
		Connection con;			//Connection Variable
		ResultSet rs = null;	//ResultSet variable to return result set
		Statement stmt;			//Statement variable to execute a static query
		try
		{
			con=Connect.connectionProvider();				//Obtaining Connection
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Train");	//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;				//Returning Result set
	}

	public int updateBook(int tId) throws InvalidTrainId	//Method to modify available seats of a particular Train after a ticket is booked
	{
		if(tId<=0)					//Exception handling to check train Id is correct or not
			throw new InvalidTrainId("Train Id provided is either zero or -ve");
		Connection con;				//Connection Variable
		PreparedStatement stmt;		//PreparedStatement variable to execute a dynamic query
		try		
		{
			con=Connect.connectionProvider();			//Obtaining Connection
			stmt=con.prepareStatement("update Train set availSeat=availSeat-1 where tId=?");		//Writing query
			stmt.setInt(1, tId);						//Setting values according to positions of ? marks
			stmt.executeUpdate();						//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

	public int updateCancel(int tId) throws InvalidTrainId	//Method to modify available seats of a particular Train after a ticket is booked
	{
		if(tId<=0)					//Exception handling to check train Id is correct or not
			throw new InvalidTrainId("Train Id provided is either zero or -ve");
		Connection con;				//Connection Variable
		PreparedStatement stmt;		//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();			//Obtaining Connection
			stmt=con.prepareStatement("update Train set availSeat=availSeat+1 where tId=?");	//Writing query
			stmt.setInt(1, tId);						//Setting values according to positions of ? marks
			stmt.executeUpdate();						//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

}
