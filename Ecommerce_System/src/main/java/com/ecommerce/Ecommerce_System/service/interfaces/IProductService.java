package com.ecommerce.Ecommerce_System.service.interfaces;

import java.util.List;

import com.ecommerce.Ecommerce_System.dto.product.ProductDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.model.ProductModel;

public interface IProductService {

	public void addProduct(ProductDto productDto, CategoryModel category, BrandModel brand);

	public List<ProductDto> listAllProducts();

	public void updateProduct(Integer productID, ProductDto productDto, CategoryModel category, BrandModel brand);

	public ProductModel getProductById(Integer productId) throws CustomException;

	public List<ProductDto> getProductByCategory(Integer categoryId) throws CustomException;

	public List<ProductDto> getProductByBrand(Integer brandId) throws CustomException;

}
