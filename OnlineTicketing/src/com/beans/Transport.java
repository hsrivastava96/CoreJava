//Super class 

package com.beans;

public class Transport 
{
	private String source,destination;
	private Date dDate;
	private int tSeat,aSeat;
	
	
	public Transport(String source, String destination, Date dDate, int tSeat,
			int aSeat) 
	{
		super();
		this.source = source;
		this.destination = destination;
		this.dDate = dDate;
		this.tSeat = tSeat;
		this.aSeat = aSeat;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Date getdDate() {
		return dDate;
	}


	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}


	public int gettSeat() {
		return tSeat;
	}


	public void settSeat(int tSeat) {
		this.tSeat = tSeat;
	}


	public int getaSeat() {
		return aSeat;
	}


	public void setaSeat(int aSeat) {
		this.aSeat = aSeat;
	}


	@Override
	public String toString() {
		return "Transport [source=" + source + ", destination=" + destination
				+ ", dDate=" + dDate + ", tSeat=" + tSeat + ", aSeat=" + aSeat
				+ "]";
	}
	
	
	
	
}
