package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {
	void add(User user); // 方法名保持对应mapper中的id一致

	void update(User user);// 参数与mapper中的parameterType一致

	void delete(int id);

	List<User> selectAll();// 查询中的返回值与mapper中的resultType一致

	User selectById(int id);

	List<User> select(User user);// 传入任何参数都能进行查询

	List<User> selectLike(User user);

	void deleteAll(int[] ids);// 批量删除
}
