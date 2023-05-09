package com.velue.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velue.dao.PackagingRepository;
import com.velue.dao.ProductRepository;
import com.velue.dto.Packaging;
import com.velue.dto.Product;
import com.velue.dto.ItemProduct;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private PackagingRepository packagingRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, PackagingRepository packagingRepository) {
		this.productRepository = productRepository;
		this.packagingRepository = packagingRepository;
	}

	@Override
	public Product addProduct(Product product) {

		return productRepository.save(product);

	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	/*
	 * @Override public Product getProductById(Long id) { return
	 * productRepository.findById(id); //return null; }
	 */

	@Override
	public ItemProduct addPackaging(Packaging packaging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Packaging> getAllPackaging() {
		// TODO Auto-generated method stub
		return packagingRepository.findAll();

		// return null;
	}

	@Override
	public Packaging getPackagingById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
