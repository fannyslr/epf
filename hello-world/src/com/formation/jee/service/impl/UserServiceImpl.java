package com.formation.jee.service.impl;

import java.util.List;

import com.formation.jee.dao.UserDao;
import com.formation.jee.domain.User;
import com.formation.jee.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.formation.jee.service.impl.UserService#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
}
