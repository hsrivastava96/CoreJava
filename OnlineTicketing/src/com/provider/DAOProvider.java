//Provider class to provide objects of DAO Logic Layer entities
package com.provider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.DAOInterface.BKInterface;
import com.DAOInterface.DAOInterface;
import com.DAOInterface.TransInterface;

public class DAOProvider 
{
	public static DAOInterface providePassenger()			//Method to provide Passenger object
	{
		DAOInterface d=null;
		try 
		{ 
			FileInputStream fis = new FileInputStream("src//com//provider//DAOLogic.properties");		//Inputing source of Properties file
			Properties p = new Properties();				//Creating object of properties type to load the source properties file
			p.load(fis);									//Loding the properties file
			String DAOClass = p.getProperty("Passenger");	//Storing the package path associated to the key "Passenger" in a string
			Class c = Class.forName(DAOClass);
			d = (DAOInterface)c.newInstance();				//Creating an object to provide of the respected class
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
		return d;											//Providing object using d
	}

	public static TransInterface provideTrain()				//Method to provide Train object
	{
		TransInterface d=null;
		try 
		{ 
			FileInputStream fis = new FileInputStream("src//com//provider//DAOLogic.properties");	//Inputing source of Properties file
			Properties p = new Properties();			//Creating object of properties type to load the source properties file
			p.load(fis);								//Loding the properties file
			String DAOClass = p.getProperty("Train");	//Storing the package path associated to the key "Train" in a string
			Class c = Class.forName(DAOClass);
			d = (TransInterface)c.newInstance();		//Creating an object to provide of the respected class
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
		return d;											//Providing object using d
	}

	public static TransInterface provideBus()				//Method to provide Bus object
	{
		TransInterface d=null;
		try 
		{ 
			FileInputStream fis = new FileInputStream("src//com//provider//DAOLogic.properties");	//Inputing source of Properties file
			Properties p = new Properties();			//Creating object of properties type to load the source properties file				
			p.load(fis);								//Loding the properties file
			String DAOClass = p.getProperty("Bus");		//Storing the package path associated to the key "Bus" in a string
			Class c = Class.forName(DAOClass);
			d = (TransInterface)c.newInstance();		//Creating an object to provide of the respected class
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
		return d;										//Providing object using d
	}

	public static TransInterface provideFlight()		//Method to provide Flight object
	{
		TransInterface d=null;
		try 
		{ 
			FileInputStream fis = new FileInputStream("src//com//provider//DAOLogic.properties");	//Inputing source of Properties file
			Properties p = new Properties();			//Creating object of properties type to load the source properties file	
			p.load(fis);								//Loding the properties file
			String DAOClass = p.getProperty("Flight");	//Storing the package path associated to the key "Flight" in a string
			Class c = Class.forName(DAOClass);
			d = (TransInterface)c.newInstance();		//Creating an object to provide of the respected class
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
		return d;										//Providing object using d
	}

	public static BKInterface provideBookings()			//Method to provide Bookings object
	{
		BKInterface d=null;
		try 
		{ 
			FileInputStream fis = new FileInputStream("src//com//provider//DAOLogic.properties");
			Properties p = new Properties();
			p.load(fis);
			String DAOClass = p.getProperty("Bookings");
			Class c = Class.forName(DAOClass);
			d = (BKInterface)c.newInstance();
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
		return d;												//Providing object using d
	}

}
