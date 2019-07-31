package com.visa.prj.entity;

public class Mobile extends Product {
	private String connectivity;

	public Mobile() {
	}

	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price);
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		// TODO Auto-generated method stub
		
		// connectivity.equals("4G") should be avoided because of NULL exception
		if("3G".contentEquals(connectivity) && getPrice()>5000 ) {
			return true;
		}
		else if("4G".contentEquals(connectivity) && getPrice() > 15000) {
			return true;
		}
		return false;
		
		
	}
	
}
