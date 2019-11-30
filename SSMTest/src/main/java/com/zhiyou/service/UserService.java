package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {
	void add(User user);

	void update(User user);

	void delete(int id);

	void deleteAll(int[] id);

	List<User> selectAll(int a, int b);

	List<User> selectByEvery(User user);

	List<User> selectByOtherInt(int number);

	List<User> selectByOtherString(String string);

}
