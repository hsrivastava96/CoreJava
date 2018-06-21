package com.exceptions;

public class InvalidTrainId extends Exception
{
	private static final long serialVersionUID = 1L;
	String str;		//String variable to display the appropriate message while handling
	
	public InvalidTrainId(String str) 	
	{
		super();
		this.str = str;
	}
	
	public String toString() 	//Method to display the appropriate message while handling exception
	{
		return str;
	}
}
