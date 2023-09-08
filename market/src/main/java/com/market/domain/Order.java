//package com.market.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Entity
//@Table(name = "tbl_order")
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int orderNo;
//	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//	private List<OrderProduct> orderProducts = new ArrayList<>();
//	
//	
//	
//	public void addOrderProduct(OrderProduct orderProduct) {
//		orderProducts.add(orderProduct);
//		orderProduct.setOrder(this);
//    }
//
//	 public static Order createOrder(OrderProduct... orderProducts) {
//        Order order = new Order();
//        for(OrderProduct orderProduct : orderProducts) {
//            order.addOrderProduct(orderProduct);
//        }
//        return order;
//    }
//	 
//	public int getTotalPrice() {
//		int totalPrice = 0;
//		for(OrderProduct orderProduct : orderProducts) {
//			totalPrice += orderProduct.getTotalPrice();
//		}
//		return totalPrice;
//	}
//	
//}
