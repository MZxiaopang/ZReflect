package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.User;

public interface UserDao {

	//
	public User UserMessage(String name);

	public List<User> selectAll();

	boolean selectByName(String string);
}
