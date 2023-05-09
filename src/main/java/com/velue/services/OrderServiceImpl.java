package com.velue.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Payment;
import com.razorpay.PaymentClient;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;
import com.velue.dao.OrderRepository;
import com.velue.dto.Order;
import com.velue.dto.OrderList;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}

	public Order getOrderById(Long id) {
		//return orderRepository.findById(id).orElseThrow(() -> nnew RuntimeException("Order not found with id " + id));
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Order not found with id " + id));
		return order;
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}


}


