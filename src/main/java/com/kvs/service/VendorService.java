package com.kvs.service;

import java.util.List;

import com.kvs.entity.Vendor;

public interface VendorService {

	public List<Vendor> getVendors();
	
	public void saveVendor(Vendor theVendor);

	public Vendor getVendor(int theId);

	public void deleteVendor(int theId);

}
