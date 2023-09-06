package com.market.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.market.dto.ProductDto;
import com.market.serivce.ProductService;

@SpringBootTest
@Transactional
public class ProductControllerTest {

	@Autowired
	private ProductService productService;
	
	@DisplayName("상품 등록 테스트")
	@Test
	@Rollback(false)
	void 상품_등록_테스트() {
		ProductDto.ProductResDto p = ProductDto.ProductResDto.builder()
				.productName("애플워치")
				.nowPrice(1000)
				.build();
		
		productService.registerProduct(p);
	}
	
	
	
}
