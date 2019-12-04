package com.zhiyou.dao.user;

import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User UserMessage(String name) {
		List<User> list = JDBCUtil.dbDQL("select * from User1 where id=?", User.class, name);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return JDBCUtil.dbDQL("select * from User1", User.class);
	}

	@Override
	public boolean selectByName(String string) {
		// TODO Auto-generated method stub
		String sql = "select *from User1 where a_name=?";
		List<User> list = JDBCUtil.dbDQL(sql, User.class, string);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

}
