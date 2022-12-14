package com.ecommerce.Ecommerce_System.service.interfaces;

import com.ecommerce.Ecommerce_System.dto.shoppingCart.AddToCartDto;
import com.ecommerce.Ecommerce_System.dto.shoppingCart.CartDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.UserModel;

public interface IShoppingCartService {

	public void addToCart(AddToCartDto addToCartDto, ProductModel product, UserModel user);

	public CartDto listCartItems(UserModel user);

	public void deleteCartItem(int cartItemId, UserModel user) throws CustomException;
}
