package com.market.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.domain.ProductHistory;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Integer> {

	@Query(nativeQuery =  true,
		   value = "SELECT * FROM tbl_product_history WHERE product_name = :productName AND price_created <= :date ORDER BY product_history_no DESC LIMIT 1")
	ProductHistory getPriceByNameAndDate(@Param("productName")String productName, @Param("date")LocalDate date);
	

}
