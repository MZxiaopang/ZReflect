package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.DeptDao;
import com.zhiyou.model.Dept;
import com.zhiyou.service.DeptService;

@Service
public class DepServiceImpl implements DeptService {

	@Autowired
	DeptDao dao;

	public void add(Dept Dept) {
		// TODO Auto-generated method stub
		dao.add(Dept);
	}

	public void update(Dept Dept) {
		// TODO Auto-generated method stub
		dao.update(Dept);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public List<Dept> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	public Dept selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
