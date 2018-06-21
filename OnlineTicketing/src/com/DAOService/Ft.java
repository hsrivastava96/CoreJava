package com.DAOService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.DAOInterface.TransInterface;
import com.exceptions.InvalidFlightId;
import com.provider.Connect;

public class Ft implements TransInterface
{

	public ResultSet search()  	//Method to return ResultSet carrying the reference to the table
	{
		Connection con;			//Connection Variable
		ResultSet rs = null;	//ResultSet variable to return result set
		Statement stmt;			//Statement variable to execute a static query
		try
		{
			con=Connect.connectionProvider();					//Obtaining Connection
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Flight");		//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;				//Returning Result set
	}

	public int updateBook(int fId)	throws InvalidFlightId		//Method to modify available seats of a particular flight after a ticket is booked
	{
		if(fId<=0)		//Exception handling to check flight Id is correct or not
			throw new InvalidFlightId("Flight Id provided is either zero or -ve");
		Connection con;					//Connection Variable
		PreparedStatement stmt;			//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();			//Obtaining Connection
			stmt=con.prepareStatement("update Flight set availSeat=availSeat-1 where fId=?");		//Writing query
			stmt.setInt(1, fId);						//Setting values according to positions of ? marks
			stmt.executeUpdate();						//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

	public int updateCancel(int fId) throws InvalidFlightId		//Method to modify available seats of a particular flight after a ticket is booked
	{
		if(fId<=0)		//Exception handling to check flight Id is correct or not
			throw new InvalidFlightId("Flight Id provided is either zero or -ve");
		Connection con;					//Connection Variable
		PreparedStatement stmt;			//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();			//Obtaining Connection
			stmt=con.prepareStatement("update Flight set availSeat=availSeat+1 where fId=?");		//Writing query
			stmt.setInt(1, fId);						//Setting values according to positions of ? marks
			stmt.executeUpdate();						//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

}
