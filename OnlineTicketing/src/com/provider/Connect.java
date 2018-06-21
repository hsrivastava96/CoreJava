package com.provider;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect 
{
	static Connection con;
	
	public static Connection connectionProvider()
	{
		try
		{
			FileInputStream f;
			Properties p;
			f=new FileInputStream("src//com//provider//info.properties");	//Inputing source of Properties file
			p=new Properties();												//Creating object of properties type to load the source properties file
			p.load(f);														//Loding the properties file
			String driver=p.getProperty("driver");							//Storing the package path associated to the key "driver" in a string
			String url=p.getProperty("url");								//Storing the package path associated to the key "url" in a string
			String user=p.getProperty("username");							//Storing the package path associated to the key "username" in a string
			String password=p.getProperty("password");						//Storing the package path associated to the key "password" in a string
			
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);			//Connecting with database and storing in a variable con to provide connection by returning con
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;															//Returning con for providing connection							
	}
}
