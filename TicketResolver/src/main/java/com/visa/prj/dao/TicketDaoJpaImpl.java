package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Report;
import com.visa.prj.entity.Ticket;

@Repository
public class TicketDaoJpaImpl implements TicketDao {

	@PersistenceContext
	EntityManager em ;
	
	
	@Override
	public List<Ticket> getOpenTickets() {
		String jpql = "select t from Ticket t where resolved_date IS NULL or resolved_by IS NULL or resolve_text IS NULL";
		TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
		return query.getResultList();
		}

	@Override
	public Ticket getTicket(int id) {
		String jpql = "select t from Ticket t where t.ticket_id = :id";
		TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<Report> getClosedTickets() {

		String jpql = "select new com.visa.prj.entity.Report(t.ticket_id. t.ticket_desc, t.resolved_by.email, t.time_taken) from Ticket t";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		return query.getResultList();
	}
	
	@Override
	public void raise_ticket(Ticket t) {
		em.persist(t);
		
	}

}
