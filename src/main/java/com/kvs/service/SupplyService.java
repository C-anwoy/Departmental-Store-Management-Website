package com.kvs.service;

import java.util.List;

import com.kvs.entity.Supply;
import com.kvs.entity.Vendor;

public interface SupplyService {

	void saveSupply(Supply theSupply);
	
	List<Supply> getSupplybyVendor(Vendor theVendor);

}
