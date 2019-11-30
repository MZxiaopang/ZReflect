package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.User;

public interface UserMapper {

	void add(User user);

	void update(User user);

	void delete(int id);

	void deleteAll(int[] id);

	List<User> selectAll(@Param("page") int a, @Param("cont") int b);

	List<User> selectByEvery(User user);

	List<User> selectByOtherInt(int number);

	List<User> selectByOtherString(String string);

}
