package com.market.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.market.dto.ProductDto.ProductResDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue
	private int productNo;
	
	@Column(nullable = false)
	private String productName;
	
	private int price;
	
	@CreationTimestamp
	private LocalDate priceDate;

	@Builder
	public Product(int productNo, String productName, int price, LocalDate priceDate) {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.priceDate = priceDate;
	}
	
	public static Product DtoToProduct(ProductResDto dto) {
		return builder()
			.productName(dto.getProductName())
			.price(dto.getPrice())
			.build();
	}
	
}
