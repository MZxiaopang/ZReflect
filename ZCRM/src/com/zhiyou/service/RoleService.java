package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Role;

public interface RoleService {
	// 增
	void add(Role user);

	// 删
	void delete(Integer id);

	// 改
	void update(Role role);

	// 根据ID查
	Role selectById(Integer id);

	// 根据角色号查
	Role selectByRole_id(String role_id);

	// 根据名字查
	List<Role> selectByName(String name, Integer page);

	boolean selectByName(String name);

	// 查询所有用户
	List<Role> selectAll(int number, int page);

	// 查数据总数
	int selectCount();
}
