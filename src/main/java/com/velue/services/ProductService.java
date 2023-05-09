package com.velue.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.velue.dto.Packaging;
import com.velue.dto.Product;
import com.velue.dto.ItemProduct;



public interface ProductService {

    //products
    
	//hhh
	//  items
	
	// for Packaging
	
	 public ItemProduct addPackaging(Packaging packaging);
	 public List<Packaging> getAllPackaging();
	 public Packaging getPackagingById(Long id);
	 
	 public Product addProduct(Product product);
	 public List<Product> getAllProducts();
	 public Product getProductsById(Long id);





}
