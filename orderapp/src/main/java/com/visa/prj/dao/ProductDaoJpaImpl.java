package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
//@Profile("prod")
public class ProductDaoJpaImpl implements ProductDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> getProducts() {
		String jpql = "from Product"; // short for getting full rows - select p from Product p
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
	}

	@Override
	public Product getProduct(int id) {
		
		//find is always based on primary key
		return em.find(Product.class, id);  //generate select by primarkey
	}

	@Override
	public int addProduct(Product p) {
		em.persist(p); // generate insert
		return 0;
	}
	

}
