package com.exceptions;

public class InvalidFlightId extends Exception
{
	private static final long serialVersionUID = 1L;
	String str;		//String variable to display the appropriate message while handling
	
	public InvalidFlightId(String str) 	
	{
		super();
		this.str = str;
	}
	
	public String toString() 	//Method to display the appropriate message while handling exception
	{
		return str;
	}
}
