package com.ecommerce.Ecommerce_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Ecommerce_System.model.CategoryModel;

public interface CategoryDao extends JpaRepository<CategoryModel, Integer> {

	CategoryModel findByCategoryName(String categoryName);
}
