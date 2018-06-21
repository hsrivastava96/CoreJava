//Data Carrier for Train Entity
package com.beans;

public class Train 
{
	private int tId;
	private Transport tTrain;
	private static int tSeries=1;
	private Ticket t;

	
	public Train( Transport tTrain, Ticket t) 
	{
		super();
		this.tId = tSeries;
		tSeries++;
		this.tTrain = tTrain;
		this.t=t;
	}


	public int gettId() {
		return tId;
	}


	public void settId(int tId) {
		this.tId = tId;
	}


	public Transport gettTrain() {
		return tTrain;
	}


	public void settTrain(Transport tTrain) {
		this.tTrain = tTrain;
	}


	public Ticket getT() {
		return t;
	}


	public void setT(Ticket t) {
		this.t = t;
	}


	@Override
	public String toString() {
		return "Train [tTrain=" + tTrain + ", t=" + t + "]";
	}

	
}
