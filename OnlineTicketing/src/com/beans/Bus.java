//Data Carrier for Bus Entity
package com.beans;

public class Bus 
{
	private int bId;
	private Transport tBus;
	private static int bSeries=1;
	private Ticket t;
	
	public Bus( Transport tBus, Ticket t)
	{
		super();
		this.bId = bSeries;
		bSeries++;
		this.tBus = tBus;
		this.t=t;
	}
	public int gettId() {
		return bId;
	}
	public void settId(int bId) {
		this.bId = bId;
	}
	public Transport gettBus() {
		return tBus;
	}
	public void settBus(Transport tBus) {
		this.tBus = tBus;
	}
	
	
	public Ticket getT() {
		return t;
	}
	public void setT(Ticket t) {
		this.t = t;
	}
	
	
	@Override
	public String toString() {
		return "Bus [tBus=" + tBus + ", t=" + t + "]";
	}
	 
	
}
