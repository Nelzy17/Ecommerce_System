package com.ecommerce.Ecommerce_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.config.ApiResponse;
import com.ecommerce.Ecommerce_System.dto.product.ReviewDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.service.interfaces.IProductService;
import com.ecommerce.Ecommerce_System.service.interfaces.IReviewService;
import com.ecommerce.Ecommerce_System.service.interfaces.IUserService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private IReviewService reviewService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IUserService userService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addReview(@RequestBody ReviewDto review) throws CustomException {

		ProductModel product = productService.getProductById(review.getProductId());

		if (product == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Product does not exists"),
					HttpStatus.CONFLICT);
		}

		UserModel user = userService.getUser(review.getUserName());

		if (user == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "User does not exists"), HttpStatus.CONFLICT);
		}

		reviewService.addReview(product, user, review);

		return new ResponseEntity<>(new ApiResponse(true, "Review has been added"), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<ReviewDto>> getReviews(@RequestParam("productId") int productId) throws CustomException {
		List<ReviewDto> reviewDto = reviewService.listReviews(productId);
		return new ResponseEntity<>(reviewDto, HttpStatus.OK);
	}
}
