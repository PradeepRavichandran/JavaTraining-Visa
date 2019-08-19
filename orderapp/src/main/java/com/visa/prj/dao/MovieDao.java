package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;


//Bad practice - 
//we haven't use interface and transactional for class itself
//								bcoz getters,setters neednt be transactional
//								as performance is affected
@Repository
@Transactional
public class MovieDao {

	@PersistenceContext
	private EntityManager em;
	
	public void addMovie(Movie m) {
		em.persist(m);  //saving movie saves actor also - cascade
	}
	
	public Movie getMovie(int id) {
		return em.find(Movie.class, id);
	}
	
	public void updateMovie(Movie m) {
		em.merge(m);
	}
	
	public void getActor(int id) {
		
	}
}
