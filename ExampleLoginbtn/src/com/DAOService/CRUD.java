package com.DAOService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DAOInterface.CRUDInterface;
import com.provider.Connect;

public class CRUD implements CRUDInterface
{
	public void insert(String pName, int hsn, int r)
	{
		try
		{
			Connection con;
			PreparedStatement stmt;
			con=Connect.connectionProvider();
			stmt=con.prepareStatement("insert into Item(hsnCode, pName, ratePerUnit) values(?, ?, ?)");
			stmt.setInt(1, hsn);
			stmt.setString(2, pName);
			stmt.setInt(3, r);
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void remove(int hsn) 
	{		
		try
		{
			Connection con;
			PreparedStatement stmt;
			con=Connect.connectionProvider();
			stmt=con.prepareStatement("delete from Item where hsnCode=?");
			stmt.setInt(1, hsn);
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultSet search() 
	{
		Connection con;			//Connection Variable
		ResultSet rs = null;	//ResultSet variable to return result set
		Statement stmt;			//Statement variable to execute a static query
		try
		{
			con=Connect.connectionProvider();					//Obtaining Connection
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Item");	//Executing query
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;				//Returning Result set
	}

	public void update(int hsn, int newHsn, String newPname, int newRate) 
	{		
		try
		{
			Connection con;
			PreparedStatement stmt;
			con=Connect.connectionProvider();
			stmt=con.prepareStatement("update Item set ratePerUnit=?, hsnCode=?, pName=? where hsnCode=?");
			stmt.setInt(1, newRate);
			stmt.setInt(2, newHsn);
			stmt.setString(3, newPname);
			stmt.setInt(4, hsn);
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
