package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.User;

public interface UserMapper {

	void add(User user);

	void update(User user);

	void delete(int id);

	List<User> selectAll();

	List<User> selectByEvery(User user);

	List<User> selectLike(User user);

	void deleteAll(int[] id);
}
