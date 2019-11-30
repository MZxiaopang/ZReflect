package com.zhiyou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;

@Repository
public class UserImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into user1(id,name,password,age) values(?,?,?,?)", user.getId(), user.getName(),
				user.getPassword(), user.getAge());
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user1 set name=?,password=?,age=? where id=?", user.getName(), user.getPassword(),
				user.getAge(), user.getId());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from user1 where id=?", id);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from user1", new userRowMapping());
	}

	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from user1 where name=?", new userRowMapping(), name);
	}

	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from user1 where id=?", new userRowMapping(), id).get(0);
	}

	class userRowMapping implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getInt("age"));
			return user;
		}

	}

}
