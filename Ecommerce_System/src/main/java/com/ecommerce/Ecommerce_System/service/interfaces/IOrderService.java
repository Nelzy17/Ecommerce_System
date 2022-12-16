package com.ecommerce.Ecommerce_System.service.interfaces;

import java.util.List;

import com.ecommerce.Ecommerce_System.dto.order.AnalyticsDto;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;
import com.ecommerce.Ecommerce_System.model.UserModel;

public interface IOrderService {

	public void addToOrder(List<ShoppingCartModel> shoppingCartModel, UserModel user);

	public AnalyticsDto getAllAnalytics(Integer totalNumberofUsers);
}
