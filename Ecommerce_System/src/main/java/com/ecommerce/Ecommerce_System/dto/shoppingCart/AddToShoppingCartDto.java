package com.ecommerce.Ecommerce_System.dto.shoppingCart;

import javax.validation.constraints.NotNull;

public class AddToShoppingCartDto {

	private Integer id;
	private @NotNull Integer productId;
	private @NotNull Integer quantity;

	public AddToShoppingCartDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ShoppingCartDto{" + "id=" + id + ", productId=" + productId + ", quantity=" + quantity + ",";
	}
}
