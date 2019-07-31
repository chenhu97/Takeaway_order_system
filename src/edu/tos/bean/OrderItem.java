package edu.tos.bean;

import java.io.Serializable;

public class OrderItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7036818601143341980L;
	private Long orderItemId;
	private Long orderId;
	private Long storeId;
	private String foodName;
	private Long quantity;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}


	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

}
