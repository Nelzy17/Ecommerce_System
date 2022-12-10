package com.ecommerce.Ecommerce_System.dto.product;

import javax.validation.constraints.NotNull;

import com.ecommerce.Ecommerce_System.model.ProductModel;

public class ProductDto {

	private Integer id;
	private @NotNull String name;
	private @NotNull String imageURL;
	private @NotNull double price;
	private @NotNull String description;
	private @NotNull Integer categoryId;
	private @NotNull Integer brandId;

	public ProductDto(@NotNull String name, @NotNull String imageURL, @NotNull double price,
			@NotNull String description, @NotNull Integer categoryId, @NotNull Integer brandId) {
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
		this.brandId = brandId;
	}

	public ProductDto(ProductModel product) {
		this.id = product.getId();
		this.name = product.getName();
		this.imageURL = product.getImageURL();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.categoryId = product.getCategory().getId();
		this.brandId = product.getBrand().getId();
	}

	public ProductDto() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
}
