package com.velue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_order")
public class ItemOrder {
		

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
    private Long productId;
    private Long ordderId;
	private double orderItemPrice;
	private double orderItemQuantityInStock;
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getOrdderId() {
		return ordderId;
	}
	public void setOrdderId(Long ordderId) {
		this.ordderId = ordderId;
	}
	public double getOrderItemPrice() {
		return orderItemPrice;
	}
	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}
	public double getOrderItemQuantityInStock() {
		return orderItemQuantityInStock;
	}
	public void setOrderItemQuantityInStock(double orderItemQuantityInStock) {
		this.orderItemQuantityInStock = orderItemQuantityInStock;
	}
	
	


}
