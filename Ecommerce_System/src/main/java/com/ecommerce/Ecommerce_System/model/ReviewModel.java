package com.ecommerce.Ecommerce_System.model;

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
@Table(name = "Review")
public class ReviewModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(targetEntity = ProductModel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductModel product;

	@ManyToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	private String review;

	public ReviewModel() {

	}

	public ReviewModel(ProductModel product, UserModel user, String review) {
		super();
		this.product = product;
		this.user = user;
		this.review = review;
	}

	public Integer getId() {
		return id;
	}

	public ProductModel getProduct() {
		return product;
	}

	public UserModel getUser() {
		return user;
	}

	public String getReview() {
		return review;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
