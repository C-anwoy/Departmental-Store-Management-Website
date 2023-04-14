package com.kvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.OrderDAO;
import com.kvs.dao.SupplyDAO;
import com.kvs.entity.Supply;
import com.kvs.entity.Vendor;

@Service
public class SupplyServiceImpl implements SupplyService {
	
	@Autowired
	private SupplyDAO supplyDAO;

	@Override
	@Transactional
	public void saveSupply(Supply theSupply) {
		
		supplyDAO.saveSupply(theSupply);
		
	}

	@Override
	@Transactional
	public List<Supply> getSupplybyVendor(Vendor theVendor) {
		
		return supplyDAO.getSupplybyVendor(theVendor);
	}

}
