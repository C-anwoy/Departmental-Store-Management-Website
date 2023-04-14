package com.kvs.service;

import java.util.List;

import com.kvs.entity.Godown;

public interface GodownService {

	List<Godown> getGodowns();
	
	void saveGodown(Godown theGodown);
	
	Godown getGodown(int theId);

	public void deleteGodown(int theId);


}
