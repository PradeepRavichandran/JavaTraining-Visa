package com.visa.prj.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticket_id;
	
	private String ticket_desc;
	private Date raised_date = new Date();
	private Date resolved_date;
	
	@ManyToOne
	@JoinColumn(name="raised_by")
	private Employee raised_by;
	
	@ManyToOne
	@JoinColumn(name="resolved_by")
	private Employee resolved_by;
	
	private String resolve_text;

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

	public Employee getRaised_by() {
		return raised_by;
	}

	public void setRaised_by(Employee e1) {
		this.raised_by = e1;
	}

	public Employee getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(Employee e2) {
		this.resolved_by = e2;
	}

	public String getResolve_text() {
		return resolve_text;
	}

	public void setResolve_text(String resolve_text) {
		this.resolve_text = resolve_text;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", ticket_desc=" + ticket_desc + ", raised_date=" + raised_date
				+ ", resolved_date=" + resolved_date + ", raised_by=" + raised_by + ", resolved_by=" + resolved_by
				+ ", resolve_text=" + resolve_text + "]";
	}
	
	

}
