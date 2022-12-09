package com.ecommerce.Ecommerce_System.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Ecommerce_System.model.BrandModel;

public interface IBrandService {

	public List<BrandModel> listBrands();

	public Optional<BrandModel> readBrand(Integer brandId);
}
