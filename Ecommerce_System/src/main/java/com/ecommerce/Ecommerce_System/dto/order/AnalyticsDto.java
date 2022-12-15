package com.ecommerce.Ecommerce_System.dto.order;

import javax.validation.constraints.NotNull;

public class AnalyticsDto {

	private @NotNull Integer users;
	private @NotNull Integer productsSold;
	private @NotNull Double totalRevenue;
	private @NotNull String product;
	private @NotNull String category;
	private @NotNull String brand;

	public AnalyticsDto() {

	}

	public AnalyticsDto(@NotNull Integer users, @NotNull Integer productsSold, @NotNull Double totalRevenue,
			@NotNull String product, @NotNull String category, @NotNull String brand) {
		super();
		this.users = users;
		this.productsSold = productsSold;
		this.totalRevenue = totalRevenue;
		this.product = product;
		this.category = category;
		this.brand = brand;
	}

	public Integer getUsers() {
		return users;
	}

	public Integer getProductsSold() {
		return productsSold;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public String getProduct() {
		return product;
	}

	public String getCategory() {
		return category;
	}

	public String getBrand() {
		return brand;
	}

	public void setUsers(Integer users) {
		this.users = users;
	}

	public void setProductsSold(Integer productsSold) {
		this.productsSold = productsSold;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
