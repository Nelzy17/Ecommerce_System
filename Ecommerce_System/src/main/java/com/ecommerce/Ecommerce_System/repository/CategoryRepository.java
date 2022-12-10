package com.ecommerce.Ecommerce_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {

	CategoryModel findByCategoryName(String categoryName);
}
