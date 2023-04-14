package com.kvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.BrandDAO;
import com.kvs.entity.Brand;


@Service
public class BrandServiceImpl implements BrandService {

	//need to inject brand dao
	@Autowired
	private BrandDAO brandDAO; 
			
	@Override
	@Transactional
	public List<Brand> getBrands() {
		
		return brandDAO.getBrands();
	}

	@Override
	@Transactional
	public void saveBrand(Brand theBrand) {
		
		brandDAO.saveBrand(theBrand);

	}

	@Override
	@Transactional
	public Brand getBrand(int theId) {
		
		Brand theBrand=brandDAO.getBrand(theId);
		
		return theBrand;
	}

	@Override
	@Transactional
	public void deleteBrand(int theId) {
		
		brandDAO.deleteBrand(theId);

	}

	@Override
	@Transactional
	public Brand getBrandbyName(String brand) {
		
		Brand theBrand=brandDAO.getBrandbyName(brand);
		
		return theBrand;
	}

}
