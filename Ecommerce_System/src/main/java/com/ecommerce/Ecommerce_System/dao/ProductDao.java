package com.ecommerce.Ecommerce_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.ProductModel;

@Repository
public interface ProductDao extends JpaRepository<ProductModel, Integer> {

}
