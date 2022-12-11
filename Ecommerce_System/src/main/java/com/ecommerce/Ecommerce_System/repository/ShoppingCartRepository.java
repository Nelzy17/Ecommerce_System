package com.ecommerce.Ecommerce_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Ecommerce_System.model.ShoppingCartModel;
import com.ecommerce.Ecommerce_System.model.UserModel;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartModel, Integer> {

	List<ShoppingCartModel> findAllByUserOrderByCreatedDateDesc(UserModel user);
}
