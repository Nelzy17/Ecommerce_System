package com.ecommerce.Ecommerce_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.model.BrandModel;
import com.ecommerce.Ecommerce_System.service.interfaces.IBrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;

	@GetMapping("/")
	public ResponseEntity<List<BrandModel>> getBrands() {
		List<BrandModel> body = brandService.listBrands();
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
}
