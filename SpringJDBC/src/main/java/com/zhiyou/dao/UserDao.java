package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.User;

public interface UserDao {

	List<User> selectByName(String name);

	void add(User user);

	void delete(int id);

	void update(User user);

	User selectOne(int id);
}
