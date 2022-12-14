package com.ecommerce.Ecommerce_System.service.interfaces;

import java.util.List;

import com.ecommerce.Ecommerce_System.dto.product.ReviewDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.UserModel;

public interface IReviewService {

	public void addReview(ProductModel product, UserModel user, ReviewDto reviewDto);

	public List<ReviewDto> listReviews(Integer productId) throws CustomException;
}
