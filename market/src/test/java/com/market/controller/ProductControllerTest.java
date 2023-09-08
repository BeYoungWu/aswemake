package com.market.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.market.dto.AccountDto;
import com.market.dto.ProductDto;
import com.market.dto.ProductHistoryDto;
import com.market.serivce.ProductService;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

	@Autowired
	private ProductService productService;
	
	@DisplayName("상품 등록 테스트")
	@Test
	@Rollback(false)
	@Order(1)
	void 상품_등록_테스트() {
		AccountDto.AccountResDto testuser = AccountDto.AccountResDto.builder()
				.password("test")
				.build();
		ProductDto.ProductResDto p1 = ProductDto.ProductResDto.builder()
				.productName("애플워치")
				.nowPrice(2000)
				.build();
		productService.registerProduct(p1, testuser);
		ProductDto.ProductResDto p2 = ProductDto.ProductResDto.builder()
				.productName("갤럭시워치")
				.nowPrice(2000)
				.build();
		productService.registerProduct(p2, testuser);
	}
	
	@DisplayName("상품 수정 테스트")
	@Test
	@Order(2)
	void 상품_수정_테스트() {
		AccountDto.AccountResDto testuser = AccountDto.AccountResDto.builder()
				.password("test")
				.build();
		ProductDto.ProductResDto p = ProductDto.ProductResDto.builder()
				.productName("애플워치")
				.nowPrice(3000)
				.build();
		productService.modifyProduct(p, testuser);
	}
	
	@DisplayName("특정 시점 가격 조회 테스트")
	@Test
	@Order(3)
	void 특정_시점_가격_조회_테스트() {
		AccountDto.AccountResDto testuser = AccountDto.AccountResDto.builder()
				.password("test")
				.build();
		ProductHistoryDto.ProductHistoryResDto ph = ProductHistoryDto.ProductHistoryResDto.builder()
				  .productName("애플워치")
				  .priceCreated(LocalDate.parse("2023-09-08", DateTimeFormatter.ISO_DATE))
				  .build();
		productService.getPriceByNameAndDate(ph, testuser);
	}
	
	@DisplayName("상품 삭제 테스트")
	@Test
	@Order(4)
	void 상품_삭제_테스트() {
		AccountDto.AccountResDto testuser = AccountDto.AccountResDto.builder()
				.password("test")
				.build();
		String productName = "갤럭시워치";
		productService.removeProduct(productName, testuser);
	}
	
}
