package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM tbl_product p WHERE p.productName = :productName")
	Product findByProductName(@Param("productName") String productName);


	

}
