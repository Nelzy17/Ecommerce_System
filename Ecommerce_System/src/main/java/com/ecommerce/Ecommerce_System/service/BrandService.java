package com.ecommerce.Ecommerce_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dao.BrandRepository;
import com.ecommerce.Ecommerce_System.model.BrandModel;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepo;

	public List<BrandModel> listBrands() {
		return brandRepo.findAll();
	}

	public Optional<BrandModel> readBrand(Integer brandId) {
		return brandRepo.findById(brandId);
	}
}
