package com.market.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.domain.Product;
import com.market.dto.ProductDto.ProductReqDto;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product getPriceByNameAndDate(String productName, LocalDate date);

	

}
