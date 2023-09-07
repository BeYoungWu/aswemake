package com.market.serivce;

import java.time.LocalDate;

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
	
	@Transactional
	public ProductHistoryDto.ProductHistoryResDto getPriceByNameAndDate(ProductHistoryDto.ProductHistoryResDto product) {
		String productName = product.getProductName();
		LocalDate date = product.getPriceCreated();
		ProductHistory ph = productHistoryRepository.getPriceByNameAndDate(productName, date);
		if (ph==null) {
			// 예외처리
			return null;
		} else {
			ProductHistoryDto.ProductHistoryResDto productHistoryDto = ProductHistoryDto.ProductHistoryResDto.builder()
					  .productName(ph.getProductName())
					  .price(ph.getPrice())
					  .priceCreated(ph.getPriceCreated())
					  .build();
			return productHistoryDto;
		}
	}

	@Transactional
	public CommonResDto modifyProduct(ProductDto.ProductResDto product) {
		Product p = Product.DtoToProduct(product);
		ProductHistory ph = ProductHistory.DtoToProductHistory(product);
		Product exist = productRepository.findByProductName(product.getProductName());
		if (exist!=null) {
			productRepository.modifyProduct(p);
			productHistoryRepository.save(ph);
			
			return CommonResDto.builder().message("상품이 수정되었습니다.").build();
		} else {
			return CommonResDto.builder().message("등록되어 있지 않은 상품입니다.").build();
		}
		
	}

	@Transactional
	public CommonResDto removeProduct(String productName) {
		Product exist = productRepository.findByProductName(productName);
		if (exist!=null) {
			productRepository.delete(exist);
			productHistoryRepository.deleteByProductName(productName);
			return CommonResDto.builder().message("상품이 삭제되었습니다.").build();
		} else {
			return CommonResDto.builder().message("등록되어 있지 않은 상품입니다.").build();
		}
		
		
		
	}

}
