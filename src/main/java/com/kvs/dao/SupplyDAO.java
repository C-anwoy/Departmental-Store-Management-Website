package com.kvs.dao;

import java.util.List;

import com.kvs.entity.Supply;
import com.kvs.entity.Vendor;

public interface SupplyDAO {

	void saveSupply(Supply theSupply);

	List<Supply> getSupplybyVendor(Vendor theVendor);

}
