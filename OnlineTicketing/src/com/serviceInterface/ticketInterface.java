//Interface to provide behavior to Business logic layer
package com.serviceInterface;

import com.beans.Date;
import com.exceptions.BusNotAvailable;
import com.exceptions.FlightNotAvailable;
import com.exceptions.TrainNotAvailable;
import com.exceptions.TypeCastException;
public interface ticketInterface 
{
	public void search(Date d, String src, String dest) throws BusNotAvailable, TrainNotAvailable, FlightNotAvailable;
	public boolean userAuth(String userName, String pass);
	public void userRegister(String u, String p);
	public void book(int id, String u, String p) throws BusNotAvailable, TrainNotAvailable, FlightNotAvailable;
	public void cancel(int id, String u, String p) throws BusNotAvailable, TrainNotAvailable, FlightNotAvailable;
	public void transfer(String u, String p, int id, String Usr_trans) throws TypeCastException;
}
