package com.kvs.service;

import java.util.List;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.User;

public interface StaffService {

	List<User> getStaffs();

	OnlineCounter getOnlineCounter(int staff_id);
	
	OfflineCounter getOfflineCounter(int staff_id);

}
