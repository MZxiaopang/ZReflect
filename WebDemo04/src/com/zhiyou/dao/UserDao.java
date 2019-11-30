package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.User;

public interface UserDao {

	// 根据账号查询用户是否存在
	User selectByUserName(String username);

	// 查询所有用户
	List<User> selectAll();

	// 增
	void add(User user);

	// 删
	void deleteById(Integer id);

	// 改
	void update(User user);

	// 根据ID查询出用户
	User selectById(Integer id);

}
