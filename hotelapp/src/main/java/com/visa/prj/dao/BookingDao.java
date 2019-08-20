/**
 * 
 */
package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;


public interface BookingDao {
	
	public List<Hotel> findHotels(String criteria);
	/**
	 * 
	 * @param id
	 * @return Hotel 
	 */
	public Hotel findHotelById(long id);
	/**
	 * 
	 * @param email
	 * @param password
	 * @return user
	 */
	public User getUser(String email, String password);
	
	public User getUserByEmail(String email);
	/**
	 * 
	 * @param booking
	 * @return bookingId [ confirmation ]
	 */
	public void makeBooking(Booking booking);
	
	public List<Booking> getAllBookingsOfUser(User user);
	
	
}
