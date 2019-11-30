package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Dept;

public interface DeptDao {
	void add(Dept Dept);

	void update(Dept Dept);

	void delete(Integer id);

	List<Dept> selectAll();

	List<Dept> selectByName(String name);

	Dept selectById(Integer id);
}
