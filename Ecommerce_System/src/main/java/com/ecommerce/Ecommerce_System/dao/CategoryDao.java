package com.ecommerce.Ecommerce_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.CategoryModel;

@Repository
public interface CategoryDao extends JpaRepository<CategoryModel, Integer> {

	CategoryModel findByCategoryName(String categoryName);
}
