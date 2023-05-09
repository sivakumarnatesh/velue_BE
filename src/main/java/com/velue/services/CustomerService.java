package com.velue.services;

import java.util.List;

import com.velue.dto.Customer;

public interface CustomerService {
	
	public List<Customer>getAllCustomers();
	public Customer getCustomerById(Long long1);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Long id);


}
