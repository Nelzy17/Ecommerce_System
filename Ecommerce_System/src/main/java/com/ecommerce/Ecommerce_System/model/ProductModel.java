package com.ecommerce.Ecommerce_System.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	private @NotNull String productName;
	private @NotNull String imageURL;
	private @NotNull double price;
	private @NotNull String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	CategoryModel category;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brand_id", nullable = false)
	BrandModel brand;

	public ProductModel() {
	}

	public ProductModel(String productName, String imageURL, double price, String description, CategoryModel category,
			BrandModel brand) {
		super();
		this.productName = productName;
		this.imageURL = imageURL;
		this.price = price;
		this.description = description;
		this.category = category;
		this.brand = brand;
	}

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
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

	public CategoryModel getCategory() {
		return category;
	}

	public BrandModel getBrand() {
		return brand;
	}

	public void setId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product{" + "productId=" + productId + ", product name='" + productName + '\'' + ", imageURL='"
				+ imageURL + '\'' + ", price=" + price + ", description='" + description + '\'' + '}';
	}
}
