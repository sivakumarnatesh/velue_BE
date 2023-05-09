package com.velue.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velue.dto.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findAll();

}

