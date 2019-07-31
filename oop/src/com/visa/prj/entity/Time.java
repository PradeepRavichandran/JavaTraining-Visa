package com.visa.prj.entity;

public class Time {
	private int hrs;
	private int min;
	public Time(int hrs, int min) {
		this.hrs = hrs;
		this.min = min;
	}
	public int getHrs() {
		return hrs;
	}
	public void setHrs(int hrs) {
		this.hrs = hrs;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
	public static Time addTime(Time t1, Time t2) {
		Time t3 = new Time(0,0);
		int m = t1.getMin() + t2.getMin();
		if(m >= 60) {
			t3.setMin(m%60);
			t3.setHrs(t1.getHrs() + t2.getHrs() + m/60);
		}
		else {
			t3.setMin(m);
			t3.setHrs(t1.getHrs()+t2.getHrs());
	}
		return t3;
	}
	
	public Time addTime(Time t1) {
		Time t3 = new Time(0,0);
		int m = this.getMin() + t1.getMin();
		if(m >= 60) {
			t3.setMin(m%60);
			t3.setHrs(this.getHrs() + t1.getHrs() + m/60);
		}
		else {
			t3.setMin(m);
			t3.setHrs(this.getHrs()+t1.getHrs());
	}
		return t3;
	}
}
