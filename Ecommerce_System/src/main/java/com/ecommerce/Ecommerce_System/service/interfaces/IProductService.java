package com.ecommerce.Ecommerce_System.service.interfaces;

import java.util.List;

import com.ecommerce.Ecommerce_System.dto.product.ProductDto;
import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.model.CategoryModel;

public interface IProductService {

	public void addProduct(ProductDto productDto, CategoryModel category, BrandModel brand);

	public List<ProductDto> listAllProducts();

	public void updateProduct(Integer productID, ProductDto productDto, CategoryModel category, BrandModel brand);

}
