package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserDao dao = new UserDaoImpl();

	@Override
	public User selectaByUserName(HttpServletRequest req, String username, String password) {

		User user = dao.selectaByUserName(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
			} else {
				req.setAttribute("msg", "密码错误，重新输入！");
				return null;
			}
		} else {
			req.setAttribute("msg", "用户不存在！");
			return null;
		}
		return user;
	}

	@Override
	public List<User> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public void add(User user) {
		dao.add(user);

	}

	@Override
	public void delectById(Integer id) {
		dao.delectById(id);

	}

	@Override
	public void update(User user) {
		dao.update(user);

	}

	@Override
	public User selectaById(Integer id) {

		return dao.selectaById(id);
	}

	@Override
	public int selectCount() {

		return dao.selectCount();
	}

}
