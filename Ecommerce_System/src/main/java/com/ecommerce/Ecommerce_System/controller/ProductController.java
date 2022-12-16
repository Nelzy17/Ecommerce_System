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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.config.ApiResponse;
import com.ecommerce.Ecommerce_System.dto.product.ProductDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.service.interfaces.IBrandService;
import com.ecommerce.Ecommerce_System.service.interfaces.ICategoryService;
import com.ecommerce.Ecommerce_System.service.interfaces.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IBrandService brandService;

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

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getProducts() {
		List<ProductDto> productDtos = productService.listAllProducts();
		return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}

	@GetMapping("/category")
	public ResponseEntity<List<ProductDto>> getProductsByCategory(@RequestParam("categoryId") int categoryId)
			throws CustomException {
		List<ProductDto> productDtos = productService.getProductByCategory(categoryId);
		return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}

	@GetMapping("/brand")
	public ResponseEntity<List<ProductDto>> getProductsByBrand(@RequestParam("brandId") int brandId)
			throws CustomException {
		List<ProductDto> productDtos = productService.getProductByBrand(brandId);
		return new ResponseEntity<>(productDtos, HttpStatus.OK);
	}

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