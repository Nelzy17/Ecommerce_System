package com.ecommerce.Ecommerce_System.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dto.product.ReviewDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.ReviewModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;

	public void addReview(ProductModel product, UserModel user, ReviewDto reviewDto) {
		ReviewModel review = getProductHelper(product, user, reviewDto);
		reviewRepo.save(review);
	}

	private static ReviewModel getProductHelper(ProductModel product, UserModel user, ReviewDto reviewDto) {
		ReviewModel review = new ReviewModel();
		review.setProduct(product);
		review.setUser(user);
		review.setReview(reviewDto.getReview());
		return review;
	}

	public List<ReviewDto> listReviews(Integer productId) throws CustomException {
		List<ReviewDto> reviewDtos;
		try {
			List<ReviewModel> reviews = reviewRepo.findAllByProductId(productId);
			reviewDtos = new ArrayList<>();
			for (ReviewModel review : reviews) {
				reviewDtos.add(new ReviewDto(review));
			}
		} catch (Exception e) {
			throw new CustomException("Product id is invalid " + productId);
		}

		return reviewDtos;
	}

}
