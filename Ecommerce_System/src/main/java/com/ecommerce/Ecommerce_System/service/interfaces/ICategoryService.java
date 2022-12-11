package com.ecommerce.Ecommerce_System.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Ecommerce_System.model.CategoryModel;

public interface ICategoryService {

	public CategoryModel readByName(String categoryName);

	public Optional<CategoryModel> readById(Integer categoryId);

	public List<CategoryModel> listAllCategories();
}
