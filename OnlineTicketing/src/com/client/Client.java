//Client Layer
package com.client;
import java.util.*;
import com.beans.Date;
import com.provider.BusinessProvider;
import com.serviceInterface.ticketInterface;

public class Client
{

	public static void main(String[] args) 
	{ 
		try
		{
			Scanner sc = new Scanner(System.in);
			ticketInterface tckt = BusinessProvider.provideObject();
			int choice=0, ch=0, id;
			do																		//Loop for Client-System interaction
			{
				System.out.println("\n\tSelect any one of the following Services:");
				System.out.println("1. User Registration \n2. Login");
				System.out.print("\t\tYour choice --> ");
				
				choice = sc.nextInt();
	
				switch(choice)
				{
					case 1:	//User Registration Case						
							Scanner s1=new Scanner(System.in);
							System.out.print("Please enter Passenger Name --> ");
							String u=s1.nextLine();
							System.out.print("Please enter Passenger Password --> ");
							String p=s1.nextLine();
							tckt.userRegister(u, p);
							break;
					
					case 2:	//User Login Case
							Scanner s=new Scanner(System.in);
							System.out.println("\n\n\t---LOGIN--");
							System.out.print("Enter Username --> ");
							String usr = s.nextLine();
							System.out.print("Enter Password --> ");
							String pss = s.nextLine();
							if(tckt.userAuth(usr,pss))
							{
								System.out.println("\n\t\tSuccessfully Logged in!!!");
								do	//Loop for Ticketing Operations
								{
									System.out.println("\n\t---Select any one of the service---");
									System.out.println("1.Search \n2.Book \n3.Cancel \n4.Transfer \n5.Exit");
									System.out.print("\t\tYour choice --> ");
									ch = sc.nextInt();
									switch(ch)
									{
										case 1:	//Searching availability case
												System.out.print("Enter the source --> ");
												String src = sc.next();
												System.out.print("Enter the destination --> ");
												String dest = sc.next();
												System.out.println("\n\t-Enter the date of departure-");
												System.out.print("Enter day --> ");
												int d = sc.nextInt();
												System.out.print("Enter Month -->  ");
												int m = sc.nextInt();
												System.out.print("Enter Year --> ");
												int y = sc.nextInt();
												tckt.search((new Date(d,m,y)),src,dest);
												break;
	
										case 2:	//Ticket Booking case
												System.out.print("Enter the Id of your choice --> ");
												id = sc.nextInt();
												tckt.book(id, usr, pss);
												break;
										
										case 3: //Ticket Canceling case
												System.out.print("Enter id of Transport to cancel --> ");
												id = sc.nextInt();												
												tckt.cancel(id, usr, pss);
												break;
										
										case 4:	//Ticket transfer case
												Scanner ss=new Scanner(System.in);
												System.out.print("Enter id of Transport to Transfer --> ");
												id = sc.nextInt();												
												System.out.print("Enter Username of other person to Transfer your ticket --> ");
												String Usr_trans=ss.nextLine();
												tckt.transfer(usr, pss, id, Usr_trans);
												break;
										
										case 5:
												System.exit(0);
									}
								}
								while(ch<5);
							}
							else
							{
								System.out.println("Not an Existing User!!!");
							}
							break;
				}
			}
			while(choice<3);
			sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
