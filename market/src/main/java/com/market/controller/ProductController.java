package com.market.controller;

import java.sql.Timestamp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping
	public ResponseEntity<CommonResDto> registerProduct(@RequestBody ProductDto.ProductResDto product) {
		
		return ResponseEntity.ok().body(productService.registerProduct(product));
	}
	
	// 아직 미완성
	@GetMapping("/get-prices/{productName}/{date}")
	public ResponseEntity<ProductDto.ProductReqDto> getPriceByNameAndDate(@PathVariable("productName") String productName, @PathVariable("date") Timestamp date) {
		ProductDto.ProductReqDto product = productService.getPriceByNameAndDate(productName,date);
		return ResponseEntity.ok().body(product);
	}
	
	@PatchMapping("/{productName}")
	public ResponseEntity<CommonResDto> modifyProduct() {
		// 만약 db에 존재한다면 이전 꺼는 end를 업데이트 해주고
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<CommonResDto> removeProduct() {
		
		return null;
	}
	
}
