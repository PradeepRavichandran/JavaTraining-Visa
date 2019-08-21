package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	//"findBy<field-name>" will generate the necessary findby code for us
	List<Product> findByCategory(String category);
	
	//we didnt use findBy so we have to specify the query to be generated 
	@Query("from Product where price >= :pr")
	List<Product> getByPriceGreaterThan(@Param("pr") double price);
}
