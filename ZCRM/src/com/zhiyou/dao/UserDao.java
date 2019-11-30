package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface UserDao {

	// 增
	void add(User user);

	// 删
	void delete(Integer id);

	// 改
	void update(User user);

	// 根据ID查
	User selectById(Integer id);

	// 根据角色号查
	User selectByUser_Name(String role_id);

	// 根据名字查
	List<User> selectByName(String name, Integer page);

	// 根据名字查
	List<User> selectByName(String name);

	// 根据手机号查
	List<User> selectByMobile(Long Mobile);

	// 根据身份证号查
	List<User> selectById_num(Long Id_num);

	// 根据银行卡号查
	List<User> selectByCard_num(Long Card_num);

	// 查询所有用户
	List<User> selectAll(int number, int page);

	// 通过部门ID查询所有用户
	List<User> selectAll(Integer DepartmentId);

	// 查询所有角色
	List<Role> selectRoleAll();

	// 查询所有部门
	List<Department> selectDepatmentAll();

	// 查数据总数
	int selectCount();
}
