package com.market.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.CommonResDto;
import com.market.dto.ProductDto;
import com.market.serivce.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	// mapping
	// 검색, 가져오기 = get
	// 데이터 삽입 = post
	// 전체 데이터 수정 = put
	// 일부 데이터 수정 = patch
	// 데이터 삭제 = delete
	
	@PostMapping("/register")
	public ResponseEntity<CommonResDto> registerProduct(@RequestBody ProductDto.ProductResDto product) {
		
		return ResponseEntity.ok().body(productService.registerProduct(product));
	}
	
	@GetMapping()
	public ResponseEntity<CommonResDto> getProductPriceByTime() {
		
		return null;
	}
	
	@PatchMapping()
	public ResponseEntity<CommonResDto> modifyProduct() {
		
		return null;
	}
	
	@DeleteMapping()
	public ResponseEntity<CommonResDto> removeProduct() {
		
		return null;
	}
	
}