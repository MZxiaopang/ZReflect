package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.User;

public interface UserDao {

	// 根据账号查询用户是否存在
	User selectByUserName(String username);

	// 查询所有用户
	List<User> selectAll();

}
