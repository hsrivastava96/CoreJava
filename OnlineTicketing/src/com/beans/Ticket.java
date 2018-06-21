//Data Carrier for Ticket Entity
package com.beans;

public class Ticket 
{
	private int tNo;
	private int tPrice;
	private static int ticSeries=1;
	
	
	public Ticket(int tPrice) 
	{
		super();
		this.tNo = ticSeries;
		ticSeries++;
		this.tPrice = tPrice;
	}


	public int gettNo() {
		return tNo;
	}


	public void settNo(int tNo) {
		this.tNo = tNo;
	}


	public int gettPrice() {
		return tPrice;
	}


	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}


	@Override
	public String toString() {
		return "Ticket [tPrice=" + tPrice + "]";
	}
	
	

}
