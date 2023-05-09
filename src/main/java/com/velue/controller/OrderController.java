package com.velue.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velue.dto.Customer;
import com.velue.dto.Order;
import com.velue.dto.OrderList;
import com.velue.services.CustomerService;
import com.velue.services.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderController {

	private OrderService orderService;
	private CustomerService customerService;

	@Autowired
	public OrderController(OrderService orderService, CustomerService customerService) {
		this.orderService = orderService;
		this.customerService = customerService;
	}

	@GetMapping("/getAllOrders")
	public List<OrderList> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		List<OrderList> orderList = new ArrayList<>();

		for (Order order : orders) {
		//	System.out.println("==order.getCustomerId()==" + order.getCustomer().getCustomerId());
			Customer customer = customerService.getCustomerById(order.getCustomerId());
			System.out.println("==gstno==" + customer.getGstno());
			OrderList orderList1 = new OrderList();
			orderList1.setGstno(customer.getGstno());
			orderList1.setFirstName(customer.getLastName());
			orderList1.setLastName(customer.getLastName());
			orderList1.setOrderStatus(order.getOrderStatus());
			orderList.add(orderList1);

		}

		return orderList;
		// return orderService.getAllOrders();
	}
// order details 
	@GetMapping("/getOrderDetails/{id}\"")
	public List<OrderList> getOrderDetails(Long order_id) {
	    Order order1 = orderService.getOrderById(order_id);
	    Long customer_id = order1.getCustomerId();
	    //customer details 
	    Customer customer = customerService.getCustomerById(customer_id);
	    //customer.getGstno()
	    String gstno=customer.getGstno();
	    String phoneNumber = customer.getPhoneNumber();
		String addressLine1 = customer.getAddressLine1();
		String addressLine2 = customer.getAddressLine2();
		

	    
	    
		List<OrderList> orderList = new ArrayList<>();

		/*
		 * for (Order order : orders) { System.out.println("==order.getCustomerId()==" +
		 * order.getCustomerId()); Customer customer1 =
		 * customerService.getCustomerById(order.getCustomerId());
		 * System.out.println("==gstno==" + customer.getGstno()); OrderList orderList1 =
		 * new OrderList(); orderList1.setGstno(customer.getGstno());
		 * orderList1.setFirstName(customer.getLastName());
		 * orderList1.setLastName(customer.getLastName());
		 * orderList1.setOrderStatus(order.getOrderStatus()); orderList.add(orderList1);
		 * 
		 * }
		 */

		return orderList;
		// return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}

	@PostMapping("/add")
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@PutMapping("/update/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		Order existingOrder = orderService.getOrderById(id);
		existingOrder.setOrderStatus(order.getOrderStatus());
		return orderService.updateOrder(existingOrder);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
	}

}
