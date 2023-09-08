package com.market.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.domain.Product;
import com.market.dto.AccountDto;
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
	public ResponseEntity<CommonResDto> registerProduct(@RequestBody ProductDto.ProductResDto product, HttpSession session) {
		AccountDto.AccountResDto loginuser = (AccountDto.AccountResDto) session.getAttribute("loginuser");
		return ResponseEntity.ok().body(productService.registerProduct(product, loginuser));
	}
	
	@PostMapping("/get-prices")
	public ResponseEntity<ProductHistoryDto.ProductHistoryResDto> getPriceByNameAndDate(@RequestBody ProductHistoryDto.ProductHistoryResDto product, HttpSession session) {
		AccountDto.AccountResDto loginuser = (AccountDto.AccountResDto) session.getAttribute("loginuser");
		ProductHistoryDto.ProductHistoryResDto productHistory = productService.getPriceByNameAndDate(product, loginuser);
		return ResponseEntity.ok().body(productHistory);
	}
	
	@PatchMapping("/modify")
	public ResponseEntity<CommonResDto> modifyProduct(@RequestBody ProductDto.ProductResDto product, HttpSession session) {
		AccountDto.AccountResDto loginuser = (AccountDto.AccountResDto) session.getAttribute("loginuser");
		return ResponseEntity.ok().body(productService.modifyProduct(product, loginuser));
	}
	
	@DeleteMapping("/remove/{productName}")
	public ResponseEntity<CommonResDto> removeProduct(@PathVariable String productName, HttpSession session) {
		AccountDto.AccountResDto loginuser = (AccountDto.AccountResDto) session.getAttribute("loginuser");
		return ResponseEntity.ok().body(productService.removeProduct(productName, loginuser));
	}
	
}
