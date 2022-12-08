package com.ecommerce.Ecommerce_System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.BrandModel;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Integer> {

	BrandModel findByBrandName(String brandName);
}
