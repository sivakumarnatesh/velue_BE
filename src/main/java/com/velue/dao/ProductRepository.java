package com.velue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velue.dto.ItemProduct;
import com.velue.dto.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAll();

}
