package com.ecommerce.Ecommerce_System.dto.shoppingCart;

import javax.validation.constraints.NotNull;

import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;

public class CartItemDto {

	private Integer id;
	private @NotNull Integer quantity;
	private @NotNull ProductModel product;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public CartItemDto(ShoppingCartModel shoppingCart) {
		this.setId(shoppingCart.getId());
		this.setQuantity(shoppingCart.getQuantity());
		this.setProduct(shoppingCart.getProduct());
	}
}
