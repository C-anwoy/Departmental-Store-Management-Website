package com.kvs.service;

import com.kvs.entity.User;
import com.kvs.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(Integer userName);
    
    User findByEmail(String email);

    void save(CrmUser crmUser);
    
    void saveStaff(CrmUser crmUser);

	void updateStaff(User theStaff);
}
