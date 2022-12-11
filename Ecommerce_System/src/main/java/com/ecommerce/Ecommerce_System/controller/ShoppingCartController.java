package com.ecommerce.Ecommerce_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.config.ApiResponse;
import com.ecommerce.Ecommerce_System.dto.shoppingCart.AddToCartDto;
import com.ecommerce.Ecommerce_System.dto.shoppingCart.CartDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.service.ProductService;
import com.ecommerce.Ecommerce_System.service.ShoppingCartService;
import com.ecommerce.Ecommerce_System.service.UserService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
			@RequestParam("UserName") String userName) throws CustomException {

		// get the user
		UserModel user = userService.getUser(userName);

		// find the product to add and add item by service
		ProductModel product = productService.getProductById(addToCartDto.getProductId());
		shoppingCartService.addToCart(addToCartDto, product, user);

		// return response
		return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("UserName") String userName) throws CustomException {
		// first authenticate the token

		// get the user
		UserModel user = userService.getUser(userName);

		// get items in the cart for the user.
		CartDto cartDto = shoppingCartService.listCartItems(user);

		return new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
	}

	// task delete cart item
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int cartItemId,
			@RequestParam("userName") String userName) throws CustomException {

		UserModel user = userService.getUser(userName);
		// method to be completed
		shoppingCartService.deleteCartItem(cartItemId, user);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
	}

}
