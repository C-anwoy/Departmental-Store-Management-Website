package com.kvs.service;

import com.kvs.dao.RoleDao;
import com.kvs.dao.UserDao;
import com.kvs.entity.Role;
import com.kvs.entity.User;
import com.kvs.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional
	public User findByUserName(Integer userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}
	
	@Transactional
	public User findByEmail(String email) {
		// check the database if the user already exists
		return userDao.findByEmail(email);
	}

	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		//user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setMiddleName(crmUser.getMiddleName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		user.setStreet(crmUser.getStreet());
		user.setCity(crmUser.getCity());
		user.setPin(crmUser.getPin());
		user.setState(crmUser.getState());
		

		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CUSTOMER")));

		 // save user in the database
		userDao.save(user);
	}

	@Transactional
	public void saveStaff(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		//user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setMiddleName(crmUser.getMiddleName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		user.setStreet(crmUser.getStreet());
		user.setCity(crmUser.getCity());
		user.setPin(crmUser.getPin());
		user.setState(crmUser.getState());
		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_STAFF")));

		 // save user in the database
		userDao.save(user);
	}
	
	
	
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Integer username=Integer.parseInt(userName);
		
		User user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getUserName()), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
		
		
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void updateStaff(User theStaff) {
		
		userDao.updateStaff(theStaff);
		
	}



	
	}

