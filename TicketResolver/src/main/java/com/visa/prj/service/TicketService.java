package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	
	@Transactional
	public void raise_ticket(Ticket t) {
		ticketDao.raise_ticket(t);  
	}
	
	public List<Ticket> openTickets(){
		return ticketDao.getOpenTickets();
	}
	
	@Transactional
	public int resolve(int id, Employee e, String text) {
		if(e.getTeam().contentEquals("IT Cell")) {
			Ticket t = ticketDao.getTicket(id);
			if(t.getResolved_by() == null || t.getResolve_text() == null || t.getResolved_date() == null) {
				t.setResolved_by(e);
				t.setResolve_text(text);
				t.setResolved_date(new Date());
				return 1;
			}
		}
		
		return 0;
	}
}
