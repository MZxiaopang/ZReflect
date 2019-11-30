package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	public User selectByName(String name) {
		// TODO Auto-generated method stub
		List<User> name2 = dao.selectByName(name);
		if (name2.size() != 0) {
			return name2.get(0);
		} else {
			return null;
		}

	}

}
