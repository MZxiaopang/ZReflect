package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.impl.UserDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

public class UserSerivceImpl implements UserService {

	UserDao dao = new UserDaoImpl();

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}

	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public User selectByUser_Name(HttpServletRequest req, String username, String password) {
		// TODO Auto-generated method stub
		User user = dao.selectByUser_Name(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {

			} else {
				req.setAttribute("msg", "密码错误");
				return null;
			}
		} else {
			req.setAttribute("msg", "用户不存在");
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
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public List<User> selectByName(String name, Integer page) {

		return dao.selectByName(name, page);

	}

	@Override
	public List<Role> selectRoleAll() {
		// TODO Auto-generated method stub
		return dao.selectRoleAll();
	}

	@Override
	public List<Department> selectDepatmentAll() {
		// TODO Auto-generated method stub
		return dao.selectDepatmentAll();
	}

	@Override
	public boolean selectByUser_Name(String string) {
		// TODO Auto-generated method stub
		List<User> list = dao.selectByName(string);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<User> selectAll(Integer DepartmentId) {
		// TODO Auto-generated method stub
		return dao.selectAll(DepartmentId);

	}

	@Override
	public boolean selectByMobile(Long Mobile) {
		// TODO Auto-generated method stub
		List<User> list = dao.selectByMobile(Mobile);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean selectById_num(Long Id_num) {
		// TODO Auto-generated method stub
		List<User> list = dao.selectById_num(Id_num);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean selectByCard_num(Long Card_num) {
		// TODO Auto-generated method stub
		List<User> list = dao.selectByCard_num(Card_num);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
