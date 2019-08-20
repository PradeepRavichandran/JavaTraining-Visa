package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class HotelClient {

	public static void main(String[] args) {

		//create spring container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
				
		ctx.scan("com.visa.prj");
		ctx.refresh();
				
		BookingService os = ctx.getBean("bookingService", BookingService.class);
		List<Hotel> hotelsList = os.findHotels("NY");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");

		for(Hotel h : hotelsList) {
			System.out.println(h);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		Hotel h = os.getHotelById(5);
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println(h);
		
		User u = new User("p@visa.com","pradr","123","pradeep");
		List<Booking> bookList = os.getAllBookingsByUser(u);
		System.out.println("---------------------------------------------------------------------------------------------------------------------");

		for(Booking b : bookList) {
		System.out.println(b);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		User user1 = os.getUser("a@visa.com", "456");
		System.out.println(user1);
		
	}

}
