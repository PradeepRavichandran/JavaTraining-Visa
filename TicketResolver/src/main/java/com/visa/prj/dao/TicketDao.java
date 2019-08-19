package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Report;
import com.visa.prj.entity.Ticket;

public interface TicketDao {

	public void raise_ticket(Ticket t);
	public List<Ticket> getOpenTickets();
	public Ticket getTicket(int id);
	public List<Report> getClosedTickets();
}
