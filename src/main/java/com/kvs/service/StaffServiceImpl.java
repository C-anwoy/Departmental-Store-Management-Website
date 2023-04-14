package com.kvs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.RoleDao;
import com.kvs.dao.UserDao;
import com.kvs.entity.OfflineCounter;
import com.kvs.entity.OnlineCounter;
import com.kvs.entity.ProductWithTotal;
import com.kvs.entity.Role;
import com.kvs.entity.User;

@Service
public class StaffServiceImpl implements StaffService {

		// need to inject user dao
		@Autowired
		private UserDao userDao;

		@Autowired
		private RoleDao roleDao;
		
	@Override
	@Transactional
	public List<User> getStaffs() {
		
		//Collection<Role> role = Arrays.asList(roleDao.findRoleByName("ROLE_STAFF"));
		
		//System.out.println("in Service");
		List<Integer> theStaffIds = userDao.getUsersbyRole("ROLE_STAFF");
		
		List<User> theStaffs = new ArrayList<User>();
		
		for(int i : theStaffIds) {
			
			theStaffs.add(userDao.findByUserName(i));
			
		}
		
		return theStaffs;
	}

	@Override
	@Transactional
	public OnlineCounter getOnlineCounter(int staff_id) {
		
		OnlineCounter theCounter = userDao.getOnlineCounter(staff_id);
		return theCounter;
	}

	@Override
	@Transactional
	public OfflineCounter getOfflineCounter(int staff_id) {
		
		OfflineCounter theCounter = userDao.getOfflineCounter(staff_id);
		return theCounter;
	}

}
