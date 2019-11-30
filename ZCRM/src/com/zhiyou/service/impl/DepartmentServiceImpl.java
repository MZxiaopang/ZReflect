package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.DepartmentDao;
import com.zhiyou.dao.impl.DepartmentDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao dao = new DepartmentDaoImpl();

	@Override
	public void add(Department dapartment) {
		// TODO Auto-generated method stub
		dao.add(dapartment);

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		dao.update(department);
	}

	@Override
	public Department selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public Department selectByDepartment_id(String Department_id) {
		// TODO Auto-generated method stub
		return dao.selectByDepartment_id(Department_id);
	}

	@Override
	public List<Department> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	@Override
	public List<Department> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public boolean selectBy_Name(String name) {
		// TODO Auto-generated method stub
		List<Department> list = dao.selectBy_Name(name);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

}
