package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.NoticeDao;
import com.zhiyou.dao.impl.NoticeDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.User;
import com.zhiyou.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	NoticeDao dao = new NoticeDaoImpl();

	@Override
	public void add(Notice notice) {
		// TODO Auto-generated method stub
		dao.add(notice);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		dao.update(notice);
	}

	@Override
	public Notice selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public Notice selectByNotice_id(Integer Notice_id) {
		// TODO Auto-generated method stub
		return dao.selectByNotice_id(Notice_id);
	}

	@Override
	public List<Notice> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	@Override
	public List<Notice> selectAll(int number, int page, User user) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page, user);
	}

	@Override
	public List<Notice> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public List<Department> selectDepartmentAll() {
		// TODO Auto-generated method stub
		return dao.selectDepartmentAll();
	}

}
