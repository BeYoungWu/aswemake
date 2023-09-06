package com.market.dto;

import java.util.List;

import com.market.dto.ProductHistoryDto.ProductHistoryResDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductDto {

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ProductResDto {
		private String productName;
		private int nowPrice;
	}
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ProductReqDto {
		private int productNo;
		private String productName;
		private int nowPrice;
		private List<ProductHistoryResDto> productHistory;
	}
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ProductModifyResDto {
		private String productName;
		private int nowPrice;
		private List<ProductHistoryResDto> productHistory;
	}
	
}
