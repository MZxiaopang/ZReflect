package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.User;

public interface UserService {

	// 根据账号查询用户是否存在
	User selectaByUserName(HttpServletRequest req, String username, String password);

	// 查询所有用户
	List<User> selectAll(int number, int page);

	// 增
	void add(User user);

	// 删
	void delectById(Integer id);

	// 改
	void update(User user);

	// 根据ID查询出用户
	User selectaById(Integer id);

	// 查询数据总条数
	int selectCount();
}
