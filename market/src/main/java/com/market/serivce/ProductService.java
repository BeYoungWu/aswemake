package com.market.serivce;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.market.domain.Product;
import com.market.dto.CommonResDto;
import com.market.dto.ProductDto;
import com.market.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	@Transactional
	public CommonResDto registerProduct(ProductDto.ProductResDto product) {
		
		// 1. 일반사용자/마트 권환 확인
		// 2. 중복되는 상품명 확인
		// 3. 제대로 기입이 되었는지 확인
		try {
			Product p = Product.DtoToProduct(product);
			productRepository.save(p);
			
			return CommonResDto.builder().message("상품이 등록되었습니다.").build();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
}
