package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SalgradeDao;
import com.zhiyou.model.Salgrade;
import com.zhiyou.service.SalgradeService;

@Service
public class SalgradeSericeImpl implements SalgradeService {

	@Autowired
	SalgradeDao dao;

	public void add(Salgrade Salgrade) {
		// TODO Auto-generated method stub
		dao.add(Salgrade);
	}

	public void update(Salgrade Salgrade) {
		// TODO Auto-generated method stub
		dao.update(Salgrade);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<Salgrade> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public List<Salgrade> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	public Salgrade selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
