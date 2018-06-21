//Interface to provide behaviour to Passenger entity
package com.DAOInterface;

import java.sql.ResultSet;

public interface DAOInterface 
{
	public int insert(String u, String p);
	public ResultSet search();
}
