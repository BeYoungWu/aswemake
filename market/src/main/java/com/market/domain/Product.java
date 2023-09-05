package com.market.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.market.dto.ProductDto.ProductResDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_account")
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	
	@Column(nullable = false)
	private String productName;
	
	private int price;
	
	private LocalDate priceDate;

	@Builder
	public Product(int productId, String productName, int price, LocalDate priceDate) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.priceDate = priceDate;
	}
	
	public static Product DtoToProduct(ProductResDto dto) {
		return builder()
			.productName(dto.getProductName())
			.price(dto.getPrice())
			.priceDate(dto.getPriceDate())
			.build();
	}
	
}
