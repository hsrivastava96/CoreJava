package com.DAOInterface;

import java.sql.ResultSet;

public interface CRUDInterface 
{
	void insert(String pName, int hsn, int r);
	void remove(int hsn);
	public ResultSet search();
	void update(int hsn, int newHsn, String newPname, int newRate);
}
