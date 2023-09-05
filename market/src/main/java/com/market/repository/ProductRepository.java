package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	

}
