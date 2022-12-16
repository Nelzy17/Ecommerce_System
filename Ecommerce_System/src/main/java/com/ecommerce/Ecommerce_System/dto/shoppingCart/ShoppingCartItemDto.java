package com.ecommerce.Ecommerce_System.dto.shoppingCart;

import javax.validation.constraints.NotNull;

import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;

public class ShoppingCartItemDto {

	private Integer id;
	private @NotNull Integer quantity;
	private @NotNull ProductModel product;

	public ShoppingCartItemDto(Integer id, @NotNull Integer quantity, @NotNull ProductModel product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}

	public ShoppingCartItemDto(ShoppingCartModel shoppingCart) {
		this.id = shoppingCart.getId();
		this.quantity = shoppingCart.getQuantity();
		this.product = shoppingCart.getProduct();
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}
}
