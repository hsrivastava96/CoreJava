//Data Carrier for Passenger Entity
package com.beans;

public class Passenger 
{
	private int pId;
	private String pName;
	private String pPass;
	private static int pSeries=1;
	
	
	public Passenger( String pName, String pPass) 
	{
		super();
		this.pId = pSeries;
		pSeries++;
		this.pName = pName;
		this.pPass = pPass;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpPass() {
		return pPass;
	}


	public void setpPass(String pPass) {
		this.pPass = pPass;
	}



	public String toString() {
		return "Passenger [pName=" + pName + ", pPass="
				+ pPass + "]";
	}
	
}
