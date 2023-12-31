package com.market.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.market.dto.ProductDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_productHistory")
@Table(name = "tbl_productHistory")
public class ProductHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productHistoryNo;
	
	@Column
	private String productName;
	
	@Column
	private int price;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate priceCreated;
	
	@Builder
	public ProductHistory(int productHistoryNo, String productName, int price, LocalDate priceCreated) {
		this.productHistoryNo = productHistoryNo;
		this.productName = productName;
		this.price = price;
		this.priceCreated = priceCreated;
	}
	
	public static ProductHistory DtoToProductHistory(ProductDto.ProductResDto dto) {
		return builder()
			.productName(dto.getProductName())
			.price(dto.getNowPrice())
			.build();
	}
	
//	public static ProductHistory DtoToProductHistory2(ProductHistoryReqDto dto) {
//		return builder()
//			.price(dto.getPrice())
//			.priceCreated(dto.getPriceCreated())
//			.build();
//	}
	
}
