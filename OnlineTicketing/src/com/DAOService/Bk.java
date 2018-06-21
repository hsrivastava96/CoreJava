package com.DAOService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DAOInterface.BKInterface;
import com.exceptions.TypeCastException;
import com.provider.Connect;

public class Bk implements BKInterface
{
	public ResultSet search()	//Method to return ResultSet carrying the reference to the table
	{
		Connection con;			//Connection Variable
		ResultSet rs = null;	//ResultSet variable to return result set
		Statement stmt;			//Statement variable to execute a static query
		try
		{
			con=Connect.connectionProvider();					//Obtaining Connection
			stmt=con.createStatement();		
			rs=stmt.executeQuery("select * from Bookings");		//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;		//Returning Result set
	}

	public int delete(int pId, int transId) throws TypeCastException	//Method to delete a tuple w.r.t constraint
	{	
		if((pId<=0)||(transId<=0))		//Exception handling to check Type mismatch exception
			throw new TypeCastException("Error in pId or transId provided");
		Connection con;					//Connection Variable
		PreparedStatement stmt;			//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();	//Obtaining Connection
			stmt=con.prepareStatement("delete from Bookings where pId=? AND Mode=?");	//Writing query 
			stmt.setInt(1, pId);				//Setting values according to positions of ? marks
			stmt.setInt(2, transId);
			stmt.executeUpdate();				//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

	public int insert(int pId, int Mode, int dd, int mm, int yy, int ticketNumber, String src, String dst, int prc)  throws TypeCastException		//Method to insert values in a table
	{
		if((pId<=0)||(Mode<=0)||(dd<=0)||(mm<=0)||(yy<=0)||(ticketNumber<=0)||(prc<=0))		//Exception handling to check Type mismatch exception
			throw new TypeCastException("Wrong Integer Input given");
		try
		{
			Connection con;							//Connection Variable
			PreparedStatement stmt;					//PreparedStatement variable to execute a dynamic query
			con=Connect.connectionProvider();		//Obtaining Connection
			stmt=con.prepareStatement("insert into Bookings(pId, Mode, dd, mm, yy, ticketNumber, Source, Destination, ticketPrice) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");		//Writing query 
			stmt.setInt(1, pId);					//Setting values according to positions of ? marks
			stmt.setInt(2, Mode);
			stmt.setInt(3, dd);
			stmt.setInt(4, mm);
			stmt.setInt(5, yy);
			stmt.setInt(6, ticketNumber);
			stmt.setString(7, src);
			stmt.setString(8, dst);
			stmt.setInt(9, prc);
			stmt.executeUpdate();		//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int update(int pId1, int pId2)  throws TypeCastException		//Method to update pIds during transfer of ticket
	{
		if((pId1<=0)||(pId2<=0))		//Exception handling to check Type mismatch exception
			throw new TypeCastException("Error in pId1 or pId2 provided");
		Connection con;					//Connection Variable
		PreparedStatement stmt;			//PreparedStatement variable to execute a dynamic query
		try
		{
			con=Connect.connectionProvider();		//Obtaining Connection
			stmt=con.prepareStatement("update Bookings set pId=? where pId=?");		//Writing query
			stmt.setInt(1, pId2);		//Setting values according to positions of ? marks
			stmt.setInt(2, pId1);
			stmt.executeUpdate();		//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return 0;
	}

}
