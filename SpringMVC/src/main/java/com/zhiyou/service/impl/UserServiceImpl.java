package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	@Transactional
	public void add(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(3);
		dao.delete(4);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}

}
