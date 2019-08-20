package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@Transactional
	public String addToBooking(HttpServletRequest req) {
//		String[] htls = req.getParameterValues("htls");   //only hotel ids will be there
//		HttpSession ses = req.getSession();
//		String email = (String) ses.getAttribute("user");
//		bs.createBooking(htls, email );

		return "redirect:index.jsp";
	}
	
}
