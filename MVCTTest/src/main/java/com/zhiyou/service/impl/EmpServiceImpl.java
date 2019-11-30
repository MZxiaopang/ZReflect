package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.EmpDao;
import com.zhiyou.model.Emp;
import com.zhiyou.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao dao;

	public void add(Emp Emp) {
		// TODO Auto-generated method stub
		dao.add(Emp);
	}

	public void update(Emp Emp) {
		// TODO Auto-generated method stub
		dao.update(Emp);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<Emp> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public List<Emp> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	public Emp selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
