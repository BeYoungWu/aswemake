package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.domain.ProductHistory;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Integer> {


	

}
