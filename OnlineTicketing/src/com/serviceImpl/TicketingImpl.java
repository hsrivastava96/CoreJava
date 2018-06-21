//Business Logic layer class
package com.serviceImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.DAOInterface.BKInterface;
import com.DAOInterface.DAOInterface;
import com.DAOInterface.TransInterface;
import com.provider.DAOProvider;
import com.serviceInterface.ticketInterface;
import com.beans.*;
import com.exceptions.BusNotAvailable;
import com.exceptions.FlightNotAvailable;
import com.exceptions.TrainNotAvailable;
import com.exceptions.TypeCastException;

public class TicketingImpl implements ticketInterface
{

	public void userRegister(String u, String p) 			//Method to register new user
	{		
		DAOInterface ob=DAOProvider.providePassenger();		//Providing object of Passenger to Passenger/DAO Interface
		ob.insert(u, p);
	}

	public boolean userAuth(String userName, String pass) 	//Login validation method
	{
		DAOInterface ob=DAOProvider.providePassenger();		//Connecting Dao Layer with Business layer using DAO interface
		ResultSet r=ob.search();							//Storing result set of Passenger entity
		try 
		{
			while(r.next())									//Loop to check if user exists or not
			{
				if((r.getString(2).equals(userName))&&(r.getString(3).equals(pass)))	//Condition to compare Username & Password
					return true;							//User Exists
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;										//User does not exist
	}

	public void search(Date d,String src,String dest) throws BusNotAvailable, TrainNotAvailable, FlightNotAvailable		//Method to search all the available transports
	{
		TransInterface ob1=DAOProvider.provideBus();		//Providing object of Bus to Transport interface
		TransInterface ob2=DAOProvider.provideTrain();		//Providing object of Train to Transport interface
		TransInterface ob3=DAOProvider.provideFlight();		//Providing object of Flight to Transport interface
		ResultSet r1=ob1.search();							//Storing result set of Bus in r1
		ResultSet r2=ob2.search();							//Storing result set of Train in r2
		ResultSet r3=ob3.search();							//Storing result set of Flight in r3
		try
		{
			System.out.println("\n\n\t\t---Available Buses---");
			System.out.println("BusId\tSource\tDestination\tTotal_Seats\tAvl_Seats\tTicket_Prc");
	
			if(r1==null)									//Bus not available exception
				throw new BusNotAvailable("Buses for provided src, dst, and date not available!");
			
			while(r1.next())								//Loop to traverse Bus result set and print all the available busses w.r.t condition written in loop's body
			{
				if((r1.getString(2).equals(src))&&(r1.getString(3).equals(dest))&&(r1.getInt(4)==d.getD())&&(r1.getInt(5)==d.getM())&&(r1.getInt(6)==d.getYr()))
					System.out.println(r1.getInt(1)+"\t"+r1.getString(2)+"\t"+r1.getString(3)+"\t\t"+r1.getInt(7)+"\t\t"+r1.getInt(8)+"\t\t"+r1.getInt(10));		
			}
			
			System.out.println("\n\n\t\t---Available Trains---");
			System.out.println("TrainId\tSource\tDestination\tTotal_Seats\tAvl_Seats\tTicket_Prc");
			
			if(r2==null)									//Train not available exception
				throw new TrainNotAvailable("Trains for provided src, dst, and date not available!");
			
			while(r2.next())								//Loop to traverse Train result set and print all the available trains w.r.t condition written in loop's body	
			{
				if((r2.getString(2).equals(src))&&(r2.getString(3).equals(dest))&&(r2.getInt(4)==d.getD())&&(r2.getInt(5)==d.getM())&&(r2.getInt(6)==d.getYr()))
					System.out.println(r2.getInt(1)+"\t"+r2.getString(2)+"\t"+r2.getString(3)+"\t\t"+r2.getInt(7)+"\t\t"+r2.getInt(8)+"\t\t"+r2.getInt(10));		
			}
			
			System.out.println("\n\n\t\t---Available Flights---");
			System.out.println("FlghtId\tSource\tDestination\tTotal_Seats\tAvl_Seats\tTicket_Prc");
			
			if(r3==null)									//Flight not available exception
				throw new FlightNotAvailable("Flights for provided src, dst, and date not available!");
			
			while(r3.next())								//Loop to traverse Flight result set and print all the available flights w.r.t condition written in loop's body
			{
				if((r3.getString(2).equals(src))&&(r3.getString(3).equals(dest))&&(r3.getInt(4)==d.getD())&&(r3.getInt(5)==d.getM())&&(r3.getInt(6)==d.getYr()))
					System.out.println(r3.getInt(1)+"\t"+r3.getString(2)+"\t"+r3.getString(3)+"\t\t"+r3.getInt(7)+"\t\t"+r3.getInt(8)+"\t\t"+r3.getInt(10));		
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void book(int id, String u, String p) throws BusNotAvailable, TrainNotAvailable, FlightNotAvailable		//Method to book ticket as per user's demand
	{
		BKInterface ob=DAOProvider.provideBookings();		//Providing object of Bookings to Bookings interface
		DAOInterface ps=DAOProvider.providePassenger();		//Providing object of Passenger to Passenger/DAO interface
		TransInterface ob1=DAOProvider.provideBus();		//Providing object of Bus to Transport interface
		TransInterface ob2=DAOProvider.provideTrain();		//Providing object of Train to Transport interface
		TransInterface ob3=DAOProvider.provideFlight();		//Providing object of Flight to Transport interface
		ResultSet r=ps.search();							//Storing result set of Passenger in r
		ResultSet r1=ob1.search();							//Storing result set of Bus in r1
		ResultSet r2=ob2.search();							//Storing result set of Train in r2
		ResultSet r3=ob3.search();							//Storing result set of Flight in r3
		int pId=0;
		try
		{
			while(r.next())									//Loop to traverse Passenger result set and get passenger ID
			{
				if((r.getString(2).equals(u))&&(r.getString(3).equals(p)))		//Condition to extract pId of provided Username & Password
					pId=r.getInt(1);
			}

			if(id/1000==1)	//Go into Bus and do the operations
			{
				if(r1==null)								//Bus not available exception
					throw new BusNotAvailable("Buses for provided src, dst, and date not available!");

				while(r1.next())
				{
					if(r1.getInt(1)==id)
					{
						ob.insert(pId, r1.getInt(1), r1.getInt(4), r1.getInt(5), r1.getInt(6), r1.getInt(9), r1.getString(2), r1.getString(3), r1.getInt(10));	//Insert ticket in Bookings table along with user credentials
						ob1.updateBook(r1.getInt(1));		//Decrease available seats in respected transport
						Bus b=new Bus(new Transport(r1.getString(2), r1.getString(3), new Date(r1.getInt(4), r1.getInt(5), r1.getInt(6)), r1.getInt(7), r1.getInt(8)), new Ticket(r1.getInt(10)));
						System.out.println("\n\tYour Ticket Details:");	
						Passenger psn=new Passenger(u, p);
						System.out.print(psn+" ");
						System.out.println(b);
					}
				}
			}
			if(id/1000==2)	//Go into Train and do the operations
			{
				if(r2==null)								//Train not available exception
					throw new TrainNotAvailable("Trains for provided src, dst, and date not available!");
				
				while(r2.next())
				{
					if(r2.getInt(1)==id)
					{
						ob.insert(pId, r2.getInt(1), r2.getInt(4), r2.getInt(5), r2.getInt(6), r2.getInt(9), r2.getString(2), r2.getString(3), r2.getInt(10));	//Insert ticket in Bookings table along with user credentials
						ob2.updateBook(r2.getInt(1));		//Decrease available seats in respected transport
						Train b=new Train(new Transport(r2.getString(2), r2.getString(3), new Date(r2.getInt(4), r2.getInt(5), r2.getInt(6)), r2.getInt(7), r2.getInt(8)), new Ticket(r2.getInt(10)));
						System.out.println("\n\tYour Ticket Details:");	
						Passenger psn=new Passenger(u, p);
						System.out.print(psn+" ");
						System.out.println(b);
					}
				}
			}
			if(id/1000==3)	//Go into Flight and do the operations
			{
				if(r3==null)								//Flight not available exception
					throw new FlightNotAvailable("Flights for provided src, dst, and date not available!");
				
				while(r3.next())
				{
					if(r3.getInt(1)==id)
					{
						ob.insert(pId, r3.getInt(1), r3.getInt(4), r3.getInt(5), r3.getInt(6), r3.getInt(9), r3.getString(2), r3.getString(3), r3.getInt(10));	//Insert ticket in Bookings table along with user credentials
						ob3.updateBook(r3.getInt(1));		//Decrease available seats in respected transport
						Flight b=new Flight(new Transport(r3.getString(2), r3.getString(3), new Date(r3.getInt(4), r3.getInt(5), r3.getInt(6)), r3.getInt(7), r3.getInt(8)), new Ticket(r3.getInt(10)));
						System.out.println("\n\tYour Ticket Details:");	
						Passenger psn=new Passenger(u, p);
						System.out.print(psn+" ");
						System.out.println(b);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void cancel(int id, String u, String p) throws BusNotAvailable, TrainNotAvailable, FlightNotAvailable		//Method to cancel ticket as per user's demand
	{
		BKInterface ob=DAOProvider.provideBookings();		//Providing object of Bookings to Bookings interface
		DAOInterface ps=DAOProvider.providePassenger();		//Providing object of Passenger to Passenger/DAO interface
		TransInterface ob1=DAOProvider.provideBus();		//Providing object of Bus to Transport interface
		TransInterface ob2=DAOProvider.provideTrain();		//Providing object of Train to Transport interface
		TransInterface ob3=DAOProvider.provideFlight();		//Providing object of Flight to Transport interface
		ResultSet r=ps.search();							//Storing result set of Passenger in r2
		ResultSet r1=ob1.search();							//Storing result set of Bus in r1
		ResultSet r2=ob2.search();							//Storing result set of Train in r2
		ResultSet r3=ob3.search();							//Storing result set of Flight in r3
		int pId=0;
		try
		{
			while(r.next())								//Loop to traverse Passenger result set and get passenger ID
			{
				if((r.getString(2).equals(u))&&(r.getString(3).equals(p)))	//Condition to extract pId of provided Username & Password
					pId=r.getInt(1);
			}			
			
			if(id/1000==1)
			{
				ob1.updateCancel(id);						//Increase available seats in respected transport
				ob.delete(pId, id);							//Delete ticket from booking table w.r.t user credentials
				while(r1.next())
				{
					if(r1.getInt(1)==id)
					{
						Bus b=new Bus(new Transport(r1.getString(2), r1.getString(3), new Date(r1.getInt(4), r1.getInt(5), r1.getInt(6)), r1.getInt(7), r1.getInt(8)), new Ticket(r1.getInt(10)));
						System.out.println("\n\tYour Cancelled Ticket Details:");	
						Passenger psn=new Passenger(u, p);
						System.out.print(psn+" ");
						System.out.println(b);
					}
				}
			}
			
			if(id/1000==2)
			{	
				ob2.updateCancel(id);						//Increase available seats in respected transport
				ob.delete(pId, id);							//Delete ticket from booking table w.r.t user credentials
				while(r2.next())
				{
					if(r2.getInt(1)==id)
					{
						Train b=new Train(new Transport(r2.getString(2), r2.getString(3), new Date(r2.getInt(4), r2.getInt(5), r2.getInt(6)), r2.getInt(7), r2.getInt(8)), new Ticket(r2.getInt(10)));
						System.out.println("\n\tYour Cancelled Ticket Details:");	
						Passenger psn=new Passenger(u, p);
						System.out.print(psn+" ");
						System.out.println(b);
					}
				}
			}
	
			if(id/1000==3)
			{
				ob3.updateCancel(id);						//Increase available seats in respected transport
				ob.delete(pId, id);							//Delete ticket from booking table w.r.t user credentials
				while(r3.next())
				{
					if(r3.getInt(1)==id)
					{
						Flight b=new Flight(new Transport(r3.getString(2), r3.getString(3), new Date(r3.getInt(4), r3.getInt(5), r3.getInt(6)), r3.getInt(7), r3.getInt(8)), new Ticket(r3.getInt(10)));
						System.out.println("\n\tYour Cancelled Ticket Details:");	
						Passenger psn=new Passenger(u, p);
						System.out.print(psn+" ");
						System.out.println(b);
					}
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void transfer(String u, String p, int id, String Usr_trans) throws TypeCastException			//Method to transfer ticket as per user's demand
	{
		DAOInterface ps=DAOProvider.providePassenger();		//Providing object of Passenger to Passenger/DAO interface
		BKInterface ob=DAOProvider.provideBookings();		//Providing object of Bookings to Bookings interface
		ResultSet r=ps.search();							//Storing result set of Passenger in r
		int pId1=0, pId2=0;
		try
		{
			while(r.next())									//Loop to traverse Passenger result set and get passenger ID
			{
				if((r.getString(2).equals(u))&&(r.getString(3).equals(p)))	//Condition to extract pId of current user
					pId1=r.getInt(1);
				if(r.getString(2).equals(Usr_trans))		//Condition to extract pId of whom ticket is to be transfered		
					pId2=r.getInt(1);
			}			
			ob.update(pId1, pId2);							//Change pIds in Bookings table
			System.out.println("\nTicket "+id+" has been successfully transferred from pId: "+pId1+" "+u+" to pId: "+pId2+" "+Usr_trans+".\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
