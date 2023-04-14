package com.kvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.CounterDAO;
import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;

@Service
public class CounterServiceImpl implements CounterService {
	
	// need to inject user dao
	@Autowired
	private CounterDAO counterDAO;

	@Override
	@Transactional
	public void saveOnlineCounter(OnlineCounter theCounter) {
		
		counterDAO.saveOnlineCounter(theCounter);
		
	}

	@Override
	@Transactional
	public List<OnlineCounter> getOnlineCounters() {
		
		List<OnlineCounter> counters = counterDAO.getOnlineCounters();
		return counters;
	}

	@Override
	@Transactional
	public OnlineCounter getOnlineCounter(int counterId) {
		
		OnlineCounter theCounter = counterDAO.getOnlineCounter(counterId);
		return theCounter;
	}

	@Override
	@Transactional
	public void saveOfflineCounter(OfflineCounter theCounter) {
		
		counterDAO.saveOfflineCounter(theCounter);
		
	}

	@Override
	@Transactional
	public List<OfflineCounter> getOfflineCounters() {
		List<OfflineCounter> counters = counterDAO.getOfflineCounters();
		return counters;
	}

	@Override
	@Transactional
	public OfflineCounter getOfflineCounter(int counterId) {
		OfflineCounter theCounter = counterDAO.getOfflineCounter(counterId);
		return theCounter;
	}

}
