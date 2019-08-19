package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.dao.MovieDao;
import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;

public class MovieClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		//bad practice-no interface used
		MovieDao dao = ctx.getBean("movieDao",MovieDao.class);
		
		Movie m = new Movie();
		m.setName("Prestige");
	
		Actor a1 = new Actor();
		a1.setName("Christian Bale");
		
		Actor a2 = new Actor();
		a2.setName("Hugh Jackman");
		
		m.getActors().add(a1);
		m.getActors().add(a2);
		
		dao.addMovie(m);
		System.out.println(m.getName()+" Saved!!");
		
	}

}
