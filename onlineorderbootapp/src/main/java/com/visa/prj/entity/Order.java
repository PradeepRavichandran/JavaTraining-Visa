package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AUTO_INCREMENT
	private int oid;
	
	@Column(name="order_date")
	@Temporal(TemporalType.TIMESTAMP)  //to include hh,mm,ss also
	private Date orderDate = new Date(); //takes the system date, user need'nt enter date
	
	@ManyToOne
	@JoinColumn(name = "customer") // FK to email of customer
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")  // FK to orders in items table
	private List<Item> items = new ArrayList<>();
	
	private double total;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
