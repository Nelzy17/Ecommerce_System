package com.ecommerce.Ecommerce_System.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "brands")
public class BrandModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private Integer id;

	@Column(name = "brand_name")
	private @NotBlank String brandName;

	public BrandModel() {
	}

	public BrandModel(@NotBlank String bandName) {
		this.brandName = bandName;
	}

	public Integer getId() {
		return id;
	}

	public String getBrandModel() {
		return this.brandName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBrandModel(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "User {brand id=" + id + ", brand name='" + brandName + "'}";
	}

}
