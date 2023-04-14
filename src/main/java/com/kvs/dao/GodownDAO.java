package com.kvs.dao;

import java.util.List;

import com.kvs.entity.Godown;

public interface GodownDAO {

	List<Godown> getGodowns();

	void saveGodown(Godown theGodown);

	Godown getGodown(int theId);

	void deleteGodown(int theId);

}
