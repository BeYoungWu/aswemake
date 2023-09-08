package com.market.serivce;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.maket.util.exception.AlreadyExistsProductException;
import com.maket.util.exception.NoAuthorityException;
import com.maket.util.exception.ReqNotFoundException;
import com.market.domain.Product;
import com.market.domain.ProductHistory;
import com.market.dto.AccountDto;
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
	public CommonResDto registerProduct(ProductDto.ProductResDto product, AccountDto.AccountResDto loginuser) {
		if (loginuser!=null) {
			if (product!=null) {
				Product exist = productRepository.findByProductName(product.getProductName());
				if (exist!=null) {
					throw new AlreadyExistsProductException("이미 등록된 상품입니다.");
				} else {
					Product p = Product.DtoToProduct(product);
					productRepository.save(p);
					ProductHistory ph = ProductHistory.DtoToProductHistory(product);
					productHistoryRepository.save(ph);
					return CommonResDto.builder().message("상품이 등록되었습니다.").build();
				}
			} else {
				throw new ReqNotFoundException("등록에 실패했습니다.");
			}
		} else {
			throw new NoAuthorityException("권한이 없습니다.");
		}
	}
	
	@Transactional
	public ProductHistoryDto.ProductHistoryResDto getPriceByNameAndDate(ProductHistoryDto.ProductHistoryResDto product, AccountDto.AccountResDto loginuser) {
		if (loginuser!=null) {
			String productName = product.getProductName();
			LocalDate date = product.getPriceCreated();
			ProductHistory ph = productHistoryRepository.getPriceByNameAndDate(productName, date);
			if (ph==null) {
				throw new ReqNotFoundException("등록되어 있지 않은 상품입니다.");
			} else {
				ProductHistoryDto.ProductHistoryResDto productHistoryDto = ProductHistoryDto.ProductHistoryResDto.builder()
						  .productName(ph.getProductName())
						  .price(ph.getPrice())
						  .priceCreated(ph.getPriceCreated())
						  .build();
				return productHistoryDto;
			}
		} else {
			throw new NoAuthorityException("권한이 없습니다.");
		}
	}

	@Transactional
	public CommonResDto modifyProduct(ProductDto.ProductResDto product, AccountDto.AccountResDto loginuser) {
		if (loginuser!=null) {
			Product p = Product.DtoToProduct(product);
			ProductHistory ph = ProductHistory.DtoToProductHistory(product);
			Product exist = productRepository.findByProductName(product.getProductName());
			if (exist!=null) {
				productRepository.modifyProduct(p);
				productHistoryRepository.save(ph);
				
				return CommonResDto.builder().message("상품이 수정되었습니다.").build();
			} else {
				throw new ReqNotFoundException("등록되어 있지 않은 상품입니다.");
			}
		} else {
			throw new NoAuthorityException("권한이 없습니다.");
		}
		
	}

	@Transactional
	public CommonResDto removeProduct(String productName, AccountDto.AccountResDto loginuser) {
		if (loginuser!=null) {
			Product exist = productRepository.findByProductName(productName);
			if (exist!=null) {
				productRepository.delete(exist);
				productHistoryRepository.deleteByProductName(productName);
				return CommonResDto.builder().message("상품이 삭제되었습니다.").build();
			} else {
				throw new ReqNotFoundException("등록되어 있지 않은 상품입니다.");
			}
		} else {
			throw new NoAuthorityException("권한이 없습니다.");
		}
	}

}
