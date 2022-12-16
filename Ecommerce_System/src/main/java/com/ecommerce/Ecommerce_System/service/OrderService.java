package com.ecommerce.Ecommerce_System.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dto.order.AnalyticsDto;
import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.model.OrderModel;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.repository.OrderRepository;
import com.ecommerce.Ecommerce_System.service.interfaces.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepo;

	public void addToOrder(List<ShoppingCartModel> shoppingCartModel, UserModel user) {

		for (ShoppingCartModel sc : shoppingCartModel) {
			OrderModel order = new OrderModel(sc.getProduct(), sc.getQuantity(), user);
			orderRepo.save(order);
		}

	}

	public AnalyticsDto getAllAnalytics(Integer totalNumberofUsers) {
		List<OrderModel> allOrders = orderRepo.findAll();
		Integer totalNumberOfItemsSold = getNumOfItemsSold(allOrders);
		Double totalRevenue = getTotalRevenue(allOrders);
		ProductModel mostSellingProduct = getMostSoldProduct(allOrders);
		CategoryModel mostSellingCategory = getMostSoldCategory(allOrders);
		BrandModel mostSellingBrand = getMostSoldBrand(allOrders);

		AnalyticsDto analyticsDto = new AnalyticsDto(totalNumberofUsers, totalNumberOfItemsSold, totalRevenue,
				mostSellingProduct.getProductName(), mostSellingCategory.getCategoryName(),
				mostSellingBrand.getBrandModel());

		return analyticsDto;

	}

	private int getNumOfItemsSold(List<OrderModel> allOrders) {

		int quantity = 0;

		for (OrderModel order : allOrders) {
			quantity += order.getQuantity();
		}

		return quantity;
	}

	private ProductModel getMostSoldProduct(List<OrderModel> allOrders) {

		Map<ProductModel, Integer> map = new HashMap<>();

		for (OrderModel order : allOrders) {
			map.put(order.getProduct(), map.getOrDefault(map.get(order.getProduct()), order.getQuantity()) + 1);
		}

		ProductModel maxProduct = null;
		int maxQuantity = -1;

		for (ProductModel prod : map.keySet()) {
			if (map.get(prod) > maxQuantity) {
				maxQuantity = map.get(prod);
				maxProduct = prod;
			}
		}

		return maxProduct;
	}

	private CategoryModel getMostSoldCategory(List<OrderModel> allOrders) {

		Map<CategoryModel, Integer> map = new HashMap<>();

		for (OrderModel order : allOrders) {
			map.put(order.getProduct().getCategory(),
					map.getOrDefault(map.get(order.getProduct().getCategory()), order.getQuantity()) + 1);
		}

		CategoryModel maxCategory = null;
		int maxQuantity = -1;

		for (CategoryModel cat : map.keySet()) {
			if (map.get(cat) > maxQuantity) {
				maxQuantity = map.get(cat);
				maxCategory = cat;
			}
		}

		return maxCategory;
	}

	private BrandModel getMostSoldBrand(List<OrderModel> allOrders) {

		Map<BrandModel, Integer> map = new HashMap<>();

		for (OrderModel order : allOrders) {
			map.put(order.getProduct().getBrand(),
					map.getOrDefault(map.get(order.getProduct().getBrand()), order.getQuantity()) + 1);
		}

		BrandModel maxBrand = null;
		int maxQuantity = -1;

		for (BrandModel cat : map.keySet()) {
			if (map.get(cat) > maxQuantity) {
				maxQuantity = map.get(cat);
				maxBrand = cat;
			}
		}

		return maxBrand;
	}

	private double getTotalRevenue(List<OrderModel> allOrders) {
		double totalRevenue = 0;
		for (OrderModel order : allOrders) {
			totalRevenue += order.getProduct().getPrice() * order.getQuantity();
		}
		return totalRevenue;
	}
}
