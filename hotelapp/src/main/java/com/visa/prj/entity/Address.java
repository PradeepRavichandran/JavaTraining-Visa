package com.visa.prj.entity;

public class Address {
	private int houseno;
	private String street;
	private String city;
	private String zipcode;
	
	public int getHouseno() {
		return houseno;
	}
	
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Address() {
	}
	
	public Address(int houseno, String street, String city, String zipcode) {
		super();
		this.houseno = houseno;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [houseno=" + houseno + ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	

}
