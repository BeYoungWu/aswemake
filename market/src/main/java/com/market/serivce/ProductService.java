package com.market.serivce;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.market.domain.Product;
import com.market.domain.ProductHistory;
import com.market.dto.CommonResDto;
import com.market.dto.ProductDto;
import com.market.dto.ProductHistoryDto;
import com.market.repository.ProductHistoryRepository;
import com.market.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductHistoryRepository productHistoryRepository;
	
	@Transactional
	public CommonResDto registerProduct(ProductDto.ProductResDto product) {
		
		// 일반사용자/마트 권환 확인 (아직 X)
		
		if (product!=null) {
			Product exist = productRepository.findByProductName(product.getProductName());
			if (exist!=null) {
				return CommonResDto.builder().message("이미 등록된 상품입니다.").build();
			} else {
				Product p = Product.DtoToProduct(product);
				productRepository.save(p);
				ProductHistory ph = ProductHistory.DtoToProductHistory(product);
				productHistoryRepository.save(ph);
				return CommonResDto.builder().message("상품이 등록되었습니다.").build();
			}
		} else {
			return CommonResDto.builder().message("정보가 부족하여 등록에 실패했습니다.").build();
		}
	}

	
	
	public ProductHistoryDto.ProductHistoryResDto getPriceByNameAndDate(ProductHistoryDto.ProductHistoryResDto product) {
		
		// date보다 같거나작은 쿼리 DESC -> 맨위에꺼가 최신꺼 정답
		String productName = product.getProductName();
		LocalDate date = product.getPriceCreated();
		ProductHistory ph = productHistoryRepository.getPriceByNameAndDate(productName, date);
		if (ph==null) {
			// 예외처리
		}
		ProductHistoryDto.ProductHistoryResDto productHistory = ProductHistoryDto.ProductHistoryResDto.builder()
																				  .productName(ph.getProductName())
																				  .price(ph.getPrice())
																				  .priceCreated(ph.getPriceCreated())
																				  .build();
		
		return productHistory;
	}

}
