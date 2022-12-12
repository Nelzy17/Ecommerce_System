package com.ecommerce.Ecommerce_System.dto.product;

import javax.validation.constraints.NotNull;

import com.ecommerce.Ecommerce_System.model.ReviewModel;

public class ReviewDto {

	private Integer id;
	private @NotNull Integer productId;
	private @NotNull String userName;
	private @NotNull String review;

	public ReviewDto() {
	}

	public ReviewDto(@NotNull Integer productId, @NotNull String userName, @NotNull String review) {
		this.productId = productId;
		this.userName = userName;
		this.review = review;
	}

	public ReviewDto(ReviewModel review) {
		this.id = review.getId();
		this.productId = review.getProduct().getProductId();
		this.userName = review.getUser().getUserName();
		this.review = review.getReview();
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public String getUserName() {
		return userName;
	}

	public String getReview() {
		return review;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
