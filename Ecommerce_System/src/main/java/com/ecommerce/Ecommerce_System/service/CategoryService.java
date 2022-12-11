package com.ecommerce.Ecommerce_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.repository.CategoryRepository;
import com.ecommerce.Ecommerce_System.service.interfaces.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

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
