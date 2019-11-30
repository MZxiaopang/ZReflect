package com.zhiyou.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

@Repository
public class UserDaoImpl implements UserDao {

	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub
		List<User> list = JDBCUtil.dbDQL("select *from user1 where name=?", User.class, name);
		return list;
	}

}
