package com.market.dto;

import java.sql.Timestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductHistoryDto {

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ProductHistoryResDto {
		private String productName;
		private int price;
		private Timestamp priceCreated;
	}
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ProductHistoryReqDto {
		private int productHistoryNo;
		private int price;
		private Timestamp priceCreated;
	}
	
	
	
}
