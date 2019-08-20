package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		String jpql = "select h from Hotel h where h.name LIKE :pr or h.city LIKE :pr or h.state LIKE :pr or h.country LIKE :pr ";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		query.setParameter("pr", ("%"+criteria+"%"));
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		String jpql = "select h from Hotel h where h.id = :pr";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		query.setParameter("pr", id);
		return query.getSingleResult();
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email = :pr1 and u.password = :pr2";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("pr1", email);
		query.setParameter("pr2", password);
		return query.getSingleResult();
			
	}

	@Override
	public long createBooking(Booking booking) {
		
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql = "select b from Booking b where b.user = :pr";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("pr", user);
		return query.getResultList();
		
	}

}
