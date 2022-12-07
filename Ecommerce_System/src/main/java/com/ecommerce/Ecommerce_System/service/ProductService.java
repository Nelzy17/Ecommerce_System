package com.ecommerce.Ecommerce_System.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dao.ProductDao;
import com.ecommerce.Ecommerce_System.dto.product.ProductDto;
import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.model.ProductModel;

@Service
public class ProductService {

	@Autowired
	private ProductDao productRepository;

	public void addProduct(ProductDto productDto, CategoryModel category) {
		ProductModel product = getProductFromDto(productDto, category);
		productRepository.save(product);
	}

	public static ProductModel getProductFromDto(ProductDto productDto, CategoryModel category) {
		ProductModel product = new ProductModel();
		product.setCategory(category);
		product.setDescription(productDto.getDescription());
		product.setImageURL(productDto.getImageURL());
		product.setPrice(productDto.getPrice());
		product.setName(productDto.getName());
		return product;
	}

	// list of all the products
	public List<ProductDto> listProducts() {
		// first fetch all the products
		List<ProductModel> products = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<>();

		for (ProductModel product : products) {
			// for each product change it to DTO
			productDtos.add(new ProductDto(product));
		}
		return productDtos;
	}

	// update a product
	public void updateProduct(Integer productID, ProductDto productDto, CategoryModel category) {
		ProductModel product = getProductFromDto(productDto, category);
		// set the id for updating
		product.setId(productID);
		// update
		productRepository.save(product);
	}

}
