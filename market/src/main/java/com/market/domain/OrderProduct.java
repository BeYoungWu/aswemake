//package com.market.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//@Table(name = "tbl_orderProduct")
//public class OrderProduct {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//    private int orderProductNo;
//	
//	@ManyToOne
//	@JoinColumn(name = "product_no")
//	private Product product;
//	
//	@ManyToOne
//	@JoinColumn(name = "order_no")
//	private Order order;
//	
//	private int orderPrice;
//    private int count;
//	
//    
//    
//	public static OrderProduct createOrderProduct(Product product, int orderPrice, int count) {
//        OrderProduct orderItem = new OrderProduct();
//        orderItem.setProduct(product);
//        orderItem.setOrderPrice(orderPrice);
//        orderItem.setCount(count);
//
//        return orderItem;
//    }
//	
//	public int getTotalPrice() {
//        return getOrderPrice() * count;
//    }
//	
//}
