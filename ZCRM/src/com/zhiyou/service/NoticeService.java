package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.User;

public interface NoticeService {
	// 增
	void add(Notice notice);

	// 删
	void delete(Integer id);

	// 改
	void update(Notice notice);

	// 根据ID查
	Notice selectById(Integer id);

	// 根据角色号查
	Notice selectByNotice_id(Integer Notice_id);

	// 根据名字查
	List<Notice> selectByName(String name);

	// 查询所有用户
	List<Notice> selectAll(int number, int page, User user);

	// 查询所有用户
	List<Notice> selectAll(int number, int page);

	List<Department> selectDepartmentAll();

	// 查数据总数
	int selectCount();
}
