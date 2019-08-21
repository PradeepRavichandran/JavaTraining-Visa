package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public List<Product> getProducts(){
		//springboot gives us this inbuilt findAll(), findById(),..
		return productDao.findAll();
	}
	
	public List<Product> getProductByPrice(double price){
		return productDao.getByPriceGreaterThan(price);
	}
	
	public List<Product> getByCategory(String category){
		return productDao.findByCategory(category);
	}
	
	public Product getById(int id) {
		//findById() returntype is optional type so we use getOne(), we ca
		//use findById().get() too
		return productDao.findById(id).get();
	}
	
	public List<Customer> getCustomers(){
		return customerDao.findAll();
	}
	
	public Customer getByEmail(String email) {
		return customerDao.findById(email).get();
	}
	
	@Transactional
	public String saveCustomer(Customer c) {
		customerDao.save(c);
		return c.getEmail();
				
	}
	@Transactional 
	public int saveProduct(Product p) {
		//springboot gives this save()
		productDao.save(p);
		return p.getId();
	}

}
