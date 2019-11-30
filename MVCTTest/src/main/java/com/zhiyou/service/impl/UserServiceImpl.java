package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	public void add(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub
		return dao.selectByName(name);
	}

	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	public boolean selectByNameBoolean(HttpServletRequest req, String name, String password) {
		// TODO Auto-generated method stub
		List<User> list = dao.selectByName(name);
		if (list.size() == 0) {
			req.getSession().setAttribute("msg", "账号不存在");
			return false;
		} else if (list.get(0).getPassword().equals(password)) {
			return true;
		} else {
			req.getSession().setAttribute("msg", "密码不正确");
			return false;
		}

	}

}
