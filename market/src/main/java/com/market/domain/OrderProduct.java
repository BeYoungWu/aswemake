package com.market.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_orderItem")
public class OrderProduct {

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	private int orderPrice;
    private int count;
	
	public static OrderProduct createOrderItem(Product product, int orderPrice, int count) {
        OrderProduct orderItem = new OrderProduct();
        orderItem.setProduct(product);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        return orderItem;
    }
	
	public int getTotalPrice() {
        return getOrderPrice() * count;
    }
	
}
