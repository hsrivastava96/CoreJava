package com.DAOService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.DAOInterface.TransInterface;
import com.exceptions.InvalidBusId;
import com.provider.Connect;

public class Bs implements TransInterface
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
			rs=stmt.executeQuery("select * from Bus");		//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;			//Returning Result set
	}

	public int updateBook(int bId) throws InvalidBusId		//Method to modify available seats of a particular bus after a ticket is booked
	{
		if(bId<=0)						//Exception handling to check bus Id is correct or not
			throw new InvalidBusId("Bus Id provided is either zero or -ve");
		Connection con;					//Connection Variable
		PreparedStatement stmt;			//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();		//Obtaining Connection
			stmt=con.prepareStatement("update Bus set availSeat=availSeat-1 where bId=?");		//Writing query 
			stmt.setInt(1, bId);					//Setting values according to positions of ? marks
			stmt.executeUpdate();					//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

	public int updateCancel(int bId) throws InvalidBusId		//Method to modify available seats of a particular bus after a ticket is booked
	{
		if(bId<=0)		//Exception handling to check bus Id is correct or not
			throw new InvalidBusId("Bus Id provided is either zero or -ve");
		Connection con;				//Connection Variable
		PreparedStatement stmt;		//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();			//Obtaining Connection
			stmt=con.prepareStatement("update Bus set availSeat=availSeat+1 where bId=?");		//Writing query 
			stmt.setInt(1, bId);						//Setting values according to positions of ? marks
			stmt.executeUpdate();						//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

}
