package com.ecommerce.Ecommerce_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.model.CategoryModel;
import com.ecommerce.Ecommerce_System.service.interfaces.ICategoryService;

@RestController
@RequestMapping("/category")

public class CateogryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/")
	public ResponseEntity<List<CategoryModel>> getCategories() {
		List<CategoryModel> categoriesList = categoryService.listAllCategories();
		return new ResponseEntity<>(categoriesList, HttpStatus.OK);
	}
}
