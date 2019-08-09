package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Product;

public interface ProductDao {
	
	//user-defined exceptions because we want it be common for whatever db we use
    int addProduct(Product p) throws PersistenceException;
    List<Product> getProducts() throws FetchException;
    Product getProduct(int id) throws FetchException;
}
