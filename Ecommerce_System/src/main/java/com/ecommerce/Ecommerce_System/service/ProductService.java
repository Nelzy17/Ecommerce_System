package com.ecommerce.Ecommerce_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dto.product.ProductDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.model.ProductModel;
import com.ecommerce.Ecommerce_System.repository.ProductRepository;
import com.ecommerce.Ecommerce_System.service.interfaces.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepo;

	public void addProduct(ProductDto productDto, CategoryModel category, BrandModel brand) {
		ProductModel product = getProductHelper(productDto, category, brand);
		productRepo.save(product);
	}

	public List<ProductDto> listAllProducts() {

		List<ProductModel> products = productRepo.findAll();
		List<ProductDto> productDtos = new ArrayList<>();

		for (ProductModel product : products) {
			productDtos.add(new ProductDto(product));
		}

		return productDtos;
	}

	public void updateProduct(Integer productID, ProductDto productDto, CategoryModel category, BrandModel brand) {
		ProductModel product = getProductHelper(productDto, category, brand);
		product.setId(productID);
		productRepo.save(product);
	}

	private static ProductModel getProductHelper(ProductDto productDto, CategoryModel category, BrandModel brand) {
		ProductModel product = new ProductModel();
		product.setCategory(category);
		product.setDescription(productDto.getDescription());
		product.setImageURL(productDto.getImageURL());
		product.setPrice(productDto.getPrice());
		product.setProductName(productDto.getProductName());
		product.setBrand(brand);
		return product;
	}

	public ProductModel getProductById(Integer productId) throws CustomException {
		Optional<ProductModel> optionalProduct = productRepo.findById(productId);
		if (!optionalProduct.isPresent())
			throw new CustomException("Product id is invalid " + productId);
		return optionalProduct.get();
	}

}
