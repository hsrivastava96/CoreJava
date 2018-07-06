package com.provider;
import java.io.FileInputStream;
import java.util.Properties;

import com.DAOInterface.CRUDInterface;

public class DAOProvider
{
	public static CRUDInterface provideCRUD()
	{
		CRUDInterface d=null;
		try
		{
			FileInputStream fis=new FileInputStream("src//com//provider//DAOLogic.properties");
			Properties p=new Properties();
			p.load(fis);
			String DAOClass=p.getProperty("crud");
			Class c=Class.forName(DAOClass);
			d = (CRUDInterface)c.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return d;
	}
}
