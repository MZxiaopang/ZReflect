package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Dept;

public interface DeptService {
	void add(Dept Dept);

	void update(Dept Dept);

	void delete(Integer id);

	List<Dept> selectAll();

	List<Dept> selectByName(String name);

	Dept selectById(Integer id);
}
