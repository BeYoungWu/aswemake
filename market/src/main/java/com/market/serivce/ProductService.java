package com.market.serivce;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.market.domain.Product;
import com.market.domain.ProductHistory;
import com.market.dto.CommonResDto;
import com.market.dto.ProductDto;
import com.market.dto.ProductHistoryDto;
import com.market.dto.ProductHistoryDto.ProductHistoryReqDto;
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

	public ProductDto.ProductReqDto getPriceByNameAndDate(String productName, Timestamp date) {
		
		// date보다 같거나작은 쿼리 DESC -> 맨위에꺼가 최신꺼 정답
		Product p = productRepository.getPriceByNameAndDate(productName, date);
		List<ProductHistoryDto.ProductHistoryResDto> historyDtoList = p.getProductHistory().stream()
							.map(history -> ProductHistoryDto.ProductHistoryResDto.builder()
																				  .price(history.getPrice())
																				  .priceCreated(history.getPriceCreated())
																				  .build())
							.collect(Collectors.toList());
											
		ProductDto.ProductReqDto product = ProductDto.ProductReqDto.builder()
													 .productNo(p.getProductNo())
													 .productName(p.getProductName())
													 .nowPrice(p.getNowPrice())
													 .productHistory(historyDtoList)
													 .build();
		
		return product;
	}

}
