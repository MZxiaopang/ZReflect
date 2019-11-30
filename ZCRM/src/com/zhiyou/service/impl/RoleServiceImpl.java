package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.RoleDao;
import com.zhiyou.dao.impl.RoleDaoImpl;
import com.zhiyou.model.Role;
import com.zhiyou.service.RoleService;

public class RoleServiceImpl implements RoleService {

	RoleDao dao = new RoleDaoImpl();

	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		dao.add(role);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		dao.update(role);
	}

	@Override
	public Role selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public Role selectByRole_id(String role_id) {
		// TODO Auto-generated method stub
		return dao.selectByRole_id(role_id);
	}

	@Override
	public List<Role> selectByName(String name, Integer page) {
		// TODO Auto-generated method stub
		return dao.selectByName(name, page);
	}

	@Override
	public List<Role> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public boolean selectByName(String name) {
		// TODO Auto-generated method stub
		List<Role> list = dao.selectByName(name);
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

}
