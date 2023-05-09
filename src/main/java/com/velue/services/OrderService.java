package com.velue.services;

import java.math.BigDecimal;
import java.util.List;


import com.velue.dto.Order;

public interface OrderService {

	public List<Order> getAllOrders();

	public Order getOrderById(Long id);

	public Order createOrder(Order order);

	public Order updateOrder(Order order);

	public void deleteOrder(Long id);
	
	

}
