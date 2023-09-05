package com.market.serivce;

import org.springframework.stereotype.Service;

import com.market.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	
	
	
}
