package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.medol.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(int id);

	List<User> selectAll();

	List<User> selectByName(String name);

	List<User> selectById(Integer id);
}
