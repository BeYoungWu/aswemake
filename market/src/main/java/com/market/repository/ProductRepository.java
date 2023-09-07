package com.market.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM tbl_product p WHERE p.productName = :productName")
	Product findByProductName(@Param("productName") String productName);

	@Modifying
	@Transactional
	@Query("UPDATE tbl_product p SET p.productName=:#{#pe.productName}, p.nowPrice=:#{#pe.nowPrice}")
	void modifyProduct(@Param("pe") Product product);


	

}
