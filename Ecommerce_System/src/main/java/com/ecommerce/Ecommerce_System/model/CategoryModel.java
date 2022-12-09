package com.ecommerce.Ecommerce_System.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Categories")
public class CategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	@Column(name = "category_name")
	private @NotBlank String categoryName;

	public CategoryModel() {
	}

	public CategoryModel(@NotBlank String categoryName) {
		this.categoryName = categoryName;

	}

	public Integer getId() {
		return categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "User {category id=" + categoryId + ", category name='" + categoryName + "'}";
	}

}
