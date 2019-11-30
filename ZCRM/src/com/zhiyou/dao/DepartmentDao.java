package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;

public interface DepartmentDao {
	// 增
	void add(Department dapartment);

	// 删
	void delete(Integer id);

	// 改
	void update(Department department);

	// 根据ID查
	Department selectById(Integer id);

	// 根据角色号查
	Department selectByDepartment_id(String Department_id);

	// 根据名字查
	List<Department> selectByName(String name);

	List<Department> selectBy_Name(String name);

	// 查询所有用户
	List<Department> selectAll(int number, int page);

	// 查数据总数
	int selectCount();
}
