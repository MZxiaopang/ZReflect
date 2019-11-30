package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.medol.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	public void add(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	public List<User> selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
