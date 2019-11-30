package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.emp;

// EMP 的DAO 接口
public interface EmpDAO {

	// 增
	void add(emp e);

	// 删
	void delete(emp e);

	// 改
	void update(emp e);

	// 查
	List<emp> selectAll();

}
