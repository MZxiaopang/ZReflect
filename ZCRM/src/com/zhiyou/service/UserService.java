package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface UserService {

	// 增
	void add(User user);

	// 删
	void delete(Integer id);

	// 改
	void update(User user);

	// 根据ID查
	User selectById(Integer id);

	boolean selectByUser_Name(String string);

	// 根据角色号查
	User selectByUser_Name(HttpServletRequest req, String username, String password);

	// 根据名字查
	List<User> selectByName(String name, Integer page);

	// 查询所有用户
	List<User> selectAll(int number, int page);

	// 根据手机号查
	boolean selectByMobile(Long Mobile);

	// 根据身份证号查
	boolean selectById_num(Long Id_num);

	// 根据银行卡号查
	boolean selectByCard_num(Long Card_num);

	// 通过部门ID查询所有用户
	List<User> selectAll(Integer DepartmentId);
	// 查询所有角色

	List<Role> selectRoleAll();

	// 查询所有部门
	List<Department> selectDepatmentAll();

	// 查数据总数
	int selectCount();
}
