package com.market.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.domain.ProductHistory;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Integer> {

	@Query("SELECT ph FROM tbl_productHistory ph WHERE ph.productName = :productName AND ph.priceCreated <= :date ORDER BY ph.priceCreated DESC")
	ProductHistory getPriceByNameAndDate(@Param("productName")String productName, @Param("date")LocalDate date);

	

}
