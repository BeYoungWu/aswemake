package com.market.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	private List<ProductHistory> productHistory;
	
	@Builder
	public Product(int productNo, String productName, int nowPrice) {
		this.productNo = productNo;
		this.productName = productName;
		this.nowPrice = nowPrice;
//		this.productHistory = productHistory;
	}
	
	public static Product DtoToProduct(ProductResDto dto) {
		return builder()
			.productName(dto.getProductName())
			.nowPrice(dto.getNowPrice())
			.build();
	}

}
