package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(Integer id);

	List<User> selectAll();

	List<User> selectByName(String name);

	User selectById(Integer id);
}
