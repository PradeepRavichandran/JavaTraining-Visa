package com.visa.prj.entity;

public class Tv extends Product {
	private String connectivity;

	public Tv() {
	}

	public Tv(int id, String name, double price, String connectivity) {
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
		return false;
	}
	

}
