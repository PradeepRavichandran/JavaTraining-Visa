package com.visa.training.jdbc;

import java.util.List;

public class ProductApp {

	public static void main(String[] args) {

		JdbcProductDAO dao = new JdbcProductDAO();
		Product test = new Product("test", (float) 199999, 100);
		Product saved = dao.save(test);
		System.out.println("Created Product with id "+saved.getId());
		System.out.println("__________________All Products_____________________");
		List<Product> all = dao.findAll();
		all.forEach(System.out::println);
	}

}
