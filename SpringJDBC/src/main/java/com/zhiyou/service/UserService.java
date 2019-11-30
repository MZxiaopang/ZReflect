package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {

	List<User> selectByName(String name);

	public void add(User user);

	public void delete(int id);

	public void update(User user);
}
