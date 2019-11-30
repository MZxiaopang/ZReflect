package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper mapper;

	public void add(User user) {
		// TODO Auto-generated method stub
		mapper.add(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		mapper.update(user);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		mapper.delete(id);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	public List<User> select(User user) {
		// TODO Auto-generated method stub
		return mapper.select(user);
	}

	public List<User> selectLike(User user) {
		// TODO Auto-generated method stub
		return mapper.selectLike(user);
	}

	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		mapper.deleteAll(ids);
	}

	public User selectById(int id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

}
