package com.ecommerce.Ecommerce_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.config.ApiResponse;
import com.ecommerce.Ecommerce_System.dto.shoppingCart.ShoppingCartDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.service.interfaces.IOrderService;
import com.ecommerce.Ecommerce_System.service.interfaces.IShoppingCartService;
import com.ecommerce.Ecommerce_System.service.interfaces.IUserService;

@RestController
@RequestMapping("/checkout")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IShoppingCartService shoppingCartService;

	@Autowired
	private IUserService userService;

	@GetMapping("/")
	public ResponseEntity<ShoppingCartDto> getCheckoutItems(@RequestParam("UserName") String userName) throws CustomException {

		UserModel user = userService.getUser(userName);
		ShoppingCartDto cartDto = shoppingCartService.listCartItems(user);

		return new ResponseEntity<ShoppingCartDto>(cartDto, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addToOrder(@RequestParam("UserName") String userName) throws CustomException {

		UserModel user = userService.getUser(userName);
		List<ShoppingCartModel> checkoutItems = shoppingCartService.getCheckoutItems(user);
		orderService.addToOrder(checkoutItems, user);
		shoppingCartService.emptyShoppingCart(checkoutItems, user);
		return new ResponseEntity<>(new ApiResponse(true, "Added to Order History"), HttpStatus.CREATED);

	}
}
