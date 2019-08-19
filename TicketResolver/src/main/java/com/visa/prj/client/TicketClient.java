package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

public class TicketClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService os = ctx.getBean("ticketService", TicketService.class);
		
		Employee e = new Employee();
		e.setEmail("p@visa.com");
		e.setName("Pradeep");
		e.setTeam("IT Cell");
//		
//		Employee a = new Employee();
//		a.setEmail("a@visa.com");
//		a.setName("Ashish");
//		a.setTeam("MAPPD");
//		
//		Employee b = new Employee();
//		b.setEmail("b@visa.com");
//		b.setName("Banu");
//		b.setTeam("DDP");
//		
//		Ticket t = new Ticket();
//		t.setRaised_by(a);
//		t.setTicket_desc("Rebbot issue");
//		t.setRaised_by(a);
//		
//		os.raise_ticket(t);
//		
//		Ticket t2 = new Ticket();
//		t2.setRaised_by(b);
//		t2.setTicket_desc("Mac issue");
//		t2.setRaised_by(b);
//		
//		os.raise_ticket(t2);
//		
		int x = os.resolve(7, e, "RAM changed!");
		if(x==1) {
			System.out.println("Ticket resolved!!");
		}
		
		List<Ticket> tickets = os.openTickets();
		for(Ticket tt : tickets) {
			System.out.println(tt);
		}
		
		
		
	}

}
