package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.User;

public interface UserService {
	void add(User user);

	void update(User user);

	void delete(Integer id);

	List<User> selectAll();

	List<User> selectByName(String name);

	boolean selectByNameBoolean(HttpServletRequest req, String name, String password);

	User selectById(Integer id);
}
