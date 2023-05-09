package com.velue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.CustomerRepository;
import com.velue.dto.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/*
	 * @Override public Customer getEmployee(String employeeid) { Optional<Customer>
	 * result = repo.findById(employeeid); if (result.isPresent()) { Customer
	 * employee = result.get(); return employee; } else { throw new
	 * RuntimeException("Employee id not found - " + employeeid); } }
	 */
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) {
		// return customerRepository.findById(id).orElseThrow(() -> nnew
		// RuntimeException("Customer not found with id " + id));
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
		return customer;
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
