package com.ecommerce.Ecommerce_System.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.config.ApiResponse;
import com.ecommerce.Ecommerce_System.dto.product.ProductDto;
import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.service.BrandService;
import com.ecommerce.Ecommerce_System.service.CategoryService;
import com.ecommerce.Ecommerce_System.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
		CategoryModel category;
		BrandModel brand;

		try {
			category = categoryService.readById(productDto.getCategoryId()).get();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category does not exist"),
					HttpStatus.CONFLICT);
		}

		try {
			brand = brandService.readBrand(productDto.getBrandId()).get();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Brand does not exist"), HttpStatus.CONFLICT);
		}

		productService.addProduct(productDto, category, brand);
		return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
	}

	// list all the products
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getProducts() {
		List<ProductDto> productDtos = productService.listAllProducts();
		return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}

	// update a product
	@PostMapping("/update/{productID}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Integer productID,
			@RequestBody @Valid ProductDto productDto) {
		CategoryModel category;
		BrandModel brand;

		try {
			category = categoryService.readById(productDto.getCategoryId()).get();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category does not exist"),
					HttpStatus.CONFLICT);
		}

		try {
			brand = brandService.readBrand(productDto.getBrandId()).get();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Brand does not exist"), HttpStatus.CONFLICT);
		}

		productService.updateProduct(productID, productDto, category, brand);
		return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
	}
}