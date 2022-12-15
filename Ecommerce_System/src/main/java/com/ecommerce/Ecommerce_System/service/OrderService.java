package com.ecommerce.Ecommerce_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.model.OrderModel;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;

	public void addToOrder(List<ShoppingCartModel> shoppingCartModel, UserModel user) {
		System.out.println("shoppingCartModel **************************************************");
		System.out.println(shoppingCartModel.size());
		for (ShoppingCartModel sc : shoppingCartModel) {
			System.out.println("" + sc.getProduct() + "   " + sc.getQuantity());
			OrderModel order = new OrderModel(sc.getProduct(), sc.getQuantity(), user);
			System.out.println(order);
			orderRepo.save(order);
		}

	}

}
