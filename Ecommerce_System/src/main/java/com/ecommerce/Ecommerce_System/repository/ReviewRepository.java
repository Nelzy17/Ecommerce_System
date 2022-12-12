package com.ecommerce.Ecommerce_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Integer> {

	List<ReviewModel> findAllByProductId(int productId);
}
