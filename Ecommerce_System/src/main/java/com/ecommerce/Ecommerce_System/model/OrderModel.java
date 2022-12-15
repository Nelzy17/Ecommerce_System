package com.ecommerce.Ecommerce_System.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "created_date")
	private Date createdDate;

	@ManyToOne(targetEntity = ProductModel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductModel product;

	@ManyToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	private int quantity;

	public OrderModel() {
	}

	public OrderModel(ProductModel product, int quantity, UserModel user) {
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.createdDate = new Date();
	}

	public Integer getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public ProductModel getProduct() {
		return product;
	}

	public UserModel getUser() {
		return user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
