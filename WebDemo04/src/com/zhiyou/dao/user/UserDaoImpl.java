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

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		String sqString = "insert into user values(null,?,?,?,?,?)";
		JDBCUtil.dbDML(sqString, user.getPassword(), user.getName(), user.getAge());
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String sqString = "delete from user where id=?";
		JDBCUtil.dbDML(sqString, id);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sqString = "update user set  password=? and name=? and  age=? ";
		JDBCUtil.dbDML(sqString, user);
	}

	@Override
	public User selectById(Integer id) {

		return JDBCUtil.dbDQL("select *from user1 where id=?", User.class, id).get(0);
	}

}
