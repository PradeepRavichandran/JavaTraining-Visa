package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {

		String CREATE_SQL = SQLUtil.generateCreateSQL(Product.class);
		
		Product p = new Product(120,"iPhone XR", 50000, "mobile", 5);
		String INSERT_SQL = SQLUtil.generateInsertSQL(p);

		
		System.out.println(CREATE_SQL);
		System.out.println(INSERT_SQL);
	}

}
