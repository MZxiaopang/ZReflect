package com.zhiyou.dao.user;

import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectByUserName(String username) {
		// TODO Auto-generated method stub
		List<User> list = JDBCUtil.dbDQL("select *from user1 where id=?", User.class, username);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return JDBCUtil.dbDQL("select *from user1", User.class);
	}

}
