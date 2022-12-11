package com.ecommerce.Ecommerce_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

	List<ProductModel> findAllByCategoryId(int categoryId);

	List<ProductModel> findAllByBrandId(int brandId);
}
