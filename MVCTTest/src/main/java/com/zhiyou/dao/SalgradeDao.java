package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Salgrade;

public interface SalgradeDao {
	void add(Salgrade Salgrade);

	void update(Salgrade Salgrade);

	void delete(Integer id);

	List<Salgrade> selectAll();

	List<Salgrade> selectByName(String name);

	Salgrade selectById(Integer id);
}
