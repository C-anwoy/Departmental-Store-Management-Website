package com.kvs.dao;

import java.util.List;

import com.kvs.entity.Vendor;

public interface VendorDAO {

	List<Vendor> getVendors();

	void saveVendor(Vendor theVendor);

	Vendor getVendor(int theId);

	void deleteVendor(int theId);

}
