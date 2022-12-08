package com.ecommerce.Ecommerce_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dao.CategoryDao;
import com.ecommerce.Ecommerce_System.model.CategoryModel;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public CategoryModel readCategory(String categoryName) {
		return categoryDao.findByCategoryName(categoryName);
	}

	public void createCategory(CategoryModel category) {
		categoryDao.save(category);
	}

	public List<CategoryModel> listCategories() {
		return categoryDao.findAll();
	}

	public Optional<CategoryModel> readCategory(Integer categoryId) {
		return categoryDao.findById(categoryId);
	}

	public void updateCategory(Integer categoryID, CategoryModel newCategory) {
		CategoryModel category = categoryDao.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		categoryDao.save(category);
	}
}
