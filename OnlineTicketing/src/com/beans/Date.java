//Data Carrier for Date Entity
package com.beans;

public class Date 
{
	private int d, m, yr;

	public Date(int d, int m, int yr) 
	{
		super();
		this.d = d;
		this.m = m;
		this.yr = yr;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getYr() {
		return yr;
	}

	public void setYr(int yr) {
		this.yr = yr;
	}

	public String toString() {
		return "Date [d=" + d + ", m=" + m + ", yr=" + yr + "]";
	}
	
	
}
