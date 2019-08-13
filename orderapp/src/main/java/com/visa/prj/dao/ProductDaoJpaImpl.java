package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
//@Profile("prod")
public class ProductDaoJpaImpl implements ProductDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> getProducts() {
		return null;
	}

	@Override
	public Product getProduct(int id) {
		
		//find is always based on primary key
		return em.find(Product.class, id);  //generate select
	}

	@Override
	public int addProduct(Product p) {
		em.persist(p); // generate insert
		return 0;
	}
	

}
