package com.zhiyou.service.Impl;

import com.zhiyou.dao.UserDao;
import com.zhiyou.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	public UserServiceImpl(UserDao userDao) {

		this.userDao = userDao;
	}

	public UserServiceImpl() {

	}

	@Override
	public String toString() {
		return "UserServiceImpl [userDao=" + userDao + "]";
	}

}
