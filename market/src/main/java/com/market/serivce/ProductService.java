package com.market.serivce;

import org.springframework.stereotype.Service;

import com.market.dto.CommonResDto;
import com.market.dto.ProductDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	public CommonResDto registerProduct(ProductDto.ProductResDto product) {
		
		
		
		return CommonResDto.builder().message("상품이 등록되었습니다.").build();
	}
	
}
