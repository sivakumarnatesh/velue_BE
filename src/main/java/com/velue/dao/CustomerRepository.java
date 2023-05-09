package com.velue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velue.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
