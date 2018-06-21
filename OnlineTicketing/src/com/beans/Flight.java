//Data Carrier for flight Entity
package com.beans;

public class Flight
{
	private int fId;
	private Transport tFlight;
	private static int fSeries=1;
	private Ticket t;

	
	public Flight(Transport tFlight, Ticket t)
	{
		super();
		this.fId = fSeries;
		fSeries++;
		this.tFlight = tFlight;
		this.t=t;
	}


	public int getfId() {
		return fId;
	}


	public void setfId(int fId) {
		this.fId = fId;
	}


	public Transport gettFlight() {
		return tFlight;
	}


	public void settFlight(Transport tFlight) {
		this.tFlight = tFlight;
	}

	

	public Ticket getT() {
		return t;
	}


	public void setT(Ticket t) {
		this.t = t;
	}


	@Override
	public String toString() {
		return "Flight [tFlight=" + tFlight + ", t=" + t + "]";
	}


	
	
}
