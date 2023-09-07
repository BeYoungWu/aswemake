package com.market.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.CommonResDto;
import com.market.dto.ProductDto;
import com.market.dto.ProductHistoryDto;
import com.market.serivce.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@PostMapping("/register")
	public ResponseEntity<CommonResDto> registerProduct(@RequestBody ProductDto.ProductResDto product) {
		
		return ResponseEntity.ok().body(productService.registerProduct(product));
	}
	
	@PostMapping("/get-prices")
	public ResponseEntity<ProductHistoryDto.ProductHistoryResDto> getPriceByNameAndDate(@RequestBody ProductHistoryDto.ProductHistoryResDto product) {
		ProductHistoryDto.ProductHistoryResDto productHistory = productService.getPriceByNameAndDate(product);
		return ResponseEntity.ok().body(productHistory);
	}
	
	@PatchMapping("/modify")
	public ResponseEntity<CommonResDto> modifyProduct(@RequestBody ProductDto.ProductResDto product) {

		return ResponseEntity.ok().body(productService.modifyProduct(product));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<CommonResDto> removeProduct(String productName) {
		
		return ResponseEntity.ok().body(productService.removeProduct(productName));
	}
	
}
