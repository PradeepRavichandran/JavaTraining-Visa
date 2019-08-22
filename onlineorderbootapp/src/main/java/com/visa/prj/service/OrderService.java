package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrders(){
		return orderDao.findAll();
	}
	
	@Transactional
	public int placeOrder(Order o) {
		orderDao.save(o);
		double total = 0.0;
		List<Item> items = o.getItems();
		for(Item i : items) {
			total += i.getAmount();
			Product p = getById((i.getProduct().getId()));
			p.setCount(p.getCount()-i.getQty()); // dirty checking will update product count			TypedQuery<Order> query = em.createQuery(jpql, Order.class);
		}
		o.setTotal(total);
		return o.getOid();
	}
	
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
