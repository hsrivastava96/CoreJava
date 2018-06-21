//Provider class to provide object of Business Logic Layer
package com.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.serviceInterface.ticketInterface;

public class BusinessProvider 
{
	public static ticketInterface provideObject()	//Method to provide object of Business logic layer
	{
		ticketInterface tckt=null;
		try 
		{ 
			FileInputStream fis = new FileInputStream("src//com//provider//BusinessLogic.properties");		//Inputing source of Properties file
			Properties p = new Properties();					//Creating object of properties type to load the source properties file
			p.load(fis);										//Loding the properties file	
			String businessClass = p.getProperty("entity");		//Storing the package path associated to the key "entity" in a string
			Class c = Class.forName(businessClass);				
			tckt = (ticketInterface)c.newInstance();			//Creating an object to provide of the respected class
		}
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return tckt;							//Provide object using tckt
		
	}
}
