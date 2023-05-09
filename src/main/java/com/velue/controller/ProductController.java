package com.velue.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.velue.dto.Packaging;
import com.velue.dto.Product;
import com.velue.dto.Role;
import com.velue.dto.User;
import com.velue.services.ProductService;
import com.velue.services.RoleService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getAllPackaging")
	public List<Packaging> findAllPackaging() {
		return productService.getAllPackaging();

	}

	@GetMapping("/getAllProducts")
	public List<Product> findAllProducts() {
		return productService.getAllProducts();

	}

	/*
	 * @PostMapping(value="/addProduct" , consumes = MediaType.IMAGE_JPEG_VALUE)
	 * public Product addProduct(@RequestBody Product product ) {
	 * //System.out.println("adduser"+user.getFirstName()); return
	 * productService.addProduct(product); }
	 */
	//multipart/form-data'
	@PostMapping(value = "/addProduct")
	  public Product addProduct(@RequestParam("packagingType") String   packagingType, 
			  @RequestParam("image") MultipartFile image,
              @RequestParam("imageType") String imageType) throws IOException {

		 System.out.println("add product");
			   
		  
		  	Product product = new Product();
		    product.setPacking_type(packagingType);
		    product.setImage(image.getBytes());
		    product.setImageType(imageType);

		   
			return productService.addProduct(product);

	  // Rest of your code here
	 
	}
}
