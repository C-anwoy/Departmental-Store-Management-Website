package com.kvs.dao;

import java.util.List;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;

public interface CounterDAO {

	void saveOnlineCounter(OnlineCounter theCounter);
	
	List<OnlineCounter> getOnlineCounters();

	OnlineCounter getOnlineCounter(int counterId);
	
	void saveOfflineCounter(OfflineCounter theCounter);
	
	List<OfflineCounter> getOfflineCounters();

	OfflineCounter getOfflineCounter(int counterId);

}
