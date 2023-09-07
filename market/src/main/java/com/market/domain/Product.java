package com.market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.market.dto.ProductDto.ProductResDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_product")
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productNo;
	
	@Column(nullable = false)
	private String productName;
	
	@Column
	private int nowPrice;
	
	@Builder
	public Product(int productNo, String productName, int nowPrice) {
		this.productNo = productNo;
		this.productName = productName;
		this.nowPrice = nowPrice;
	}
	
	public static Product DtoToProduct(ProductResDto dto) {
		return builder()
			.productName(dto.getProductName())
			.nowPrice(dto.getNowPrice())
			.build();
	}

}
