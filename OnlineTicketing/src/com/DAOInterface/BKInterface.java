//Interface to provide behaviour to Booking entity
package com.DAOInterface;

import java.sql.ResultSet;
import com.exceptions.TypeCastException;

public interface BKInterface 
{
	public int insert(int pId, int Mode, int dd, int mm, int yy, int ticketNumber, String src, String dst, int prc) throws TypeCastException;
	public ResultSet search();
	public int update(int pId1, int pId2) throws TypeCastException;
	public int delete(int pId, int transId) throws TypeCastException;
}
