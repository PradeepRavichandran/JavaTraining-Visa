package com.visa.prj.entity;

import java.util.HashMap;
import java.util.Map;

public class Employee {

	private int employeeid;
	private String email;
	private String name;
	public Employee(int employeeid, String email, String name) {
		super();
		this.employeeid = employeeid;
		this.email = email;
		this.name = name;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
