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

	public void deleteAll(int[] id) {
		// TODO Auto-generated method stub
		mapper.deleteAll(id);
	}

	public List<User> selectAll(int a, int b) {
		// TODO Auto-generated method stub
		return mapper.selectAll(a, b);
	}

	public List<User> selectByEvery(User user) {
		// TODO Auto-generated method stub
		return mapper.selectByEvery(user);
	}

	public List<User> selectByOtherInt(int number) {
		// TODO Auto-generated method stub
		return mapper.selectByOtherInt(number);
	}

	public List<User> selectByOtherString(String string) {
		// TODO Auto-generated method stub
		return mapper.selectByOtherString(string);
	}

}
