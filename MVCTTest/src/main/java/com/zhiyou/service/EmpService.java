package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Emp;

public interface EmpService {
	void add(Emp Emp);

	void update(Emp Emp);

	void delete(Integer id);

	List<Emp> selectAll();

	List<Emp> selectByName(String name);

	Emp selectById(Integer id);
}
