package com.ecommerce.Ecommerce_System.dto.shoppingCart;

import java.util.List;

public class ShoppingCartDto {

	private List<ShoppingCartItemDto> shoppingCartItems;

	private double totalCost;

	public ShoppingCartDto(List<ShoppingCartItemDto> shoppingCartItemDtoList, double totalCost) {
		this.shoppingCartItems = shoppingCartItemDtoList;
		this.totalCost = totalCost;
	}

	public List<ShoppingCartItemDto> getcartItems() {
		return shoppingCartItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setCartItems(List<ShoppingCartItemDto> shoppingCartItemDtoList) {
		this.shoppingCartItems = shoppingCartItemDtoList;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}
