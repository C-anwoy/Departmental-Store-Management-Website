package com.kvs.dao;

import java.util.Collection;
import java.util.List;

import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.Role;
import com.kvs.entity.User;

public interface UserDao {

    User findByUserName(Integer userName);
    
    User findByEmail(String email);
    
    void save(User user);

	List getUsersbyRole(String roleName);

	void updateStaff(User theStaff);

	OnlineCounter getOnlineCounter(int staff_id);

	OfflineCounter getOfflineCounter(int staff_id);
    
}
