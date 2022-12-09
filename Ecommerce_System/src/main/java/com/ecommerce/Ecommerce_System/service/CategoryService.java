package com.ecommerce.Ecommerce_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dao.CategoryRepository;
import com.ecommerce.Ecommerce_System.model.CategoryModel;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public CategoryModel readByName(String categoryName) {
		return categoryRepo.findByCategoryName(categoryName);
	}

	public Optional<CategoryModel> readById(Integer categoryId) {
		return categoryRepo.findById(categoryId);
	}

	public List<CategoryModel> listAllCategories() {
		return categoryRepo.findAll();
	}
}
