package com.visa.prj.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
public class HotelController {
	@Autowired
	BookingService bs;
	
	@RequestMapping("Listhotels.do")
	public ModelAndView getHotels(HttpServletRequest req) {
		String criteria = req.getParameter("criteria");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("hotels", bs.findHotels(criteria));
		return mav;
	}
	
	@RequestMapping("booking.do")
	public ModelAndView BookingDetails(@RequestParam("ToBook") long hid, HttpServletRequest req) {
		
		Hotel h = new Hotel();
		h = bs.getHotelById(hid);
		
		HttpSession ses = req.getSession();
		User u = bs.getUserByEmail((String)ses.getAttribute("user"));
		
		Booking b = new Booking();
		b.setHotel(h);
		b.setUser(u);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingForm.jsp");
		mav.addObject("booking", b);

		return mav;
	}

	@RequestMapping("makeBooking.do")
	public String BookingDetails(@ModelAttribute("booking") Booking b) {
		bs.makeBooking(b);
		return "index.jsp";
	}
	
	@RequestMapping("search.do")
	public String search() {
		
		return "searchCriteria.jsp";
	}
	
	@RequestMapping("userbookings.do")
	public ModelAndView ViewBookings(HttpServletRequest req){
		HttpSession ses = req.getSession();
		User u = bs.getUserByEmail((String)ses.getAttribute("user"));
		List<Booking> bookList = bs.getAllBookingsByUser(u);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewBookings.jsp");
		mav.addObject("bookList", bookList);

		return mav;	
		}

}
