package com.visa.prj.entity;

import java.util.Date;

public class Report {

	private int ticket_id;
	private String ticket_desc;
	private Employee resolved_by;
	private Date raised_date;
	private Date resolved_date;
	private int time_taken;
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getTicket_desc() {
		return ticket_desc;
	}
	public void setTicket_desc(String ticket_desc) {
		this.ticket_desc = ticket_desc;
	}
	public Employee getResolved_by() {
		return resolved_by;
	}
	public void setResolved_by(Employee resolved_by) {
		this.resolved_by = resolved_by;
	}
	public Date getRaised_date() {
		return raised_date;
	}
	public void setRaised_date(Date raised_date) {
		this.raised_date = raised_date;
	}
	public Date getResolved_date() {
		return resolved_date;
	}
	public void setResolved_date(Date resolved_date) {
		this.resolved_date = resolved_date;
	}
	public int getTime_taken() {
		return time_taken;
	}
	public void setTime_taken(int time_taken) {
		this.time_taken = time_taken;
	}
	
	
	
	
	
}
