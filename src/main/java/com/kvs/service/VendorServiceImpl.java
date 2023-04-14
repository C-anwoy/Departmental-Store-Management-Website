package com.kvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.VendorDAO;
import com.kvs.entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	
	//need to inject vendor dao
	@Autowired
	private VendorDAO vendorDAO; 

	@Override
	@Transactional
	public List<Vendor> getVendors() {
		return vendorDAO.getVendors();
	}

	
	@Override
	@Transactional
	public void saveVendor(Vendor theVendor) {

		vendorDAO.saveVendor(theVendor);

	}


	@Override
	@Transactional
	public Vendor getVendor(int theId) {
		
		Vendor theVendor=vendorDAO.getVendor(theId);
		
		return theVendor;
	}


	@Override
	@Transactional
	public void deleteVendor(int theId) {

		vendorDAO.deleteVendor(theId);
		
	}

}
