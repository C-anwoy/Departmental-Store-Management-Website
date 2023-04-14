package com.kvs.dao;

import com.kvs.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
