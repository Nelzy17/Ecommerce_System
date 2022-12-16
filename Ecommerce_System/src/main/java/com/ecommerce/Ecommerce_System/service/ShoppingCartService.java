package com.ecommerce.Ecommerce_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dto.shoppingCart.AddToShoppingCartDto;
import com.ecommerce.Ecommerce_System.dto.shoppingCart.ShoppingCartDto;
import com.ecommerce.Ecommerce_System.dto.shoppingCart.ShoppingCartItemDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.repository.ShoppingCartRepository;
import com.ecommerce.Ecommerce_System.service.interfaces.IShoppingCartService;

@Service
public class ShoppingCartService implements IShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepo;

	public void addToCart(AddToShoppingCartDto addToCartDto, ProductModel product, UserModel user) {
		ShoppingCartModel cart = new ShoppingCartModel(product, addToCartDto.getQuantity(), user);
		shoppingCartRepo.save(cart);
	}

	public ShoppingCartDto listCartItems(UserModel user) {
		// first get all the cart items for user
		List<ShoppingCartModel> cartList = shoppingCartRepo.findAllByUserOrderByCreatedDateDesc(user);

		// convert cart to cartItemDto
		List<ShoppingCartItemDto> cartItems = new ArrayList<>();
		for (ShoppingCartModel cart : cartList) {
			ShoppingCartItemDto cartItemDto = new ShoppingCartItemDto(cart);
			cartItems.add(cartItemDto);
		}

		// calculate the total price
		double totalCost = 0;
		for (ShoppingCartItemDto cartItemDto : cartItems) {
			totalCost += cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity();
		}

		// return cart DTO
		return new ShoppingCartDto(cartItems, totalCost);
	}

	public void deleteCartItem(int cartItemId, UserModel user) throws CustomException {
		Optional<ShoppingCartModel> optionalCart = shoppingCartRepo.findById(cartItemId);

		if (!optionalCart.isPresent()) {
			throw new CustomException("cartItemId not valid");
		}
		ShoppingCartModel cart = optionalCart.get();

		if (cart.getUser() != user) {
			throw new CustomException("cart item does not belong to user");
		}
		shoppingCartRepo.deleteById(cartItemId);
	}

	public List<ShoppingCartModel> getCheckoutItems(UserModel user) {
		List<ShoppingCartModel> cartList = shoppingCartRepo.findAllByUserOrderByCreatedDateDesc(user);
		return cartList;
	}

	public void emptyShoppingCart(List<ShoppingCartModel> shoppingCartModel, UserModel user) throws CustomException {
		for (ShoppingCartModel sc : shoppingCartModel) {
			deleteCartItem(sc.getId(), user);
		}
	}
}
