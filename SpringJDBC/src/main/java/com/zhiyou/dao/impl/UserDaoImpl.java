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

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user1(id,name,password) values(?,?,?)";
		jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user1 where id=?";
		jdbcTemplate.update(sql, id);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update user1 set name=? where id=?";
		jdbcTemplate.update(sql, user.getName(), user.getId());

	}

	public List<User> selectByName(String name) {
		// TODO Auto-generated method stub

		return jdbcTemplate.query("select *from user1", new userRowMapper());

	}

	class userRowMapper implements RowMapper<User> {
		// 在查询的时候 Springjdbc会将查询到的结果集存入到这里，然后进行对结果集对象的封装
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User u = new User(rs.getInt("id"), rs.getString("password"), rs.getString("name"), rs.getInt("age"));
			return u;
		}

	}

	public User selectOne(int id) {
//		System.out.println(11);
		User user = jdbcTemplate.queryForObject("select * from user1 where id=?", new userRowMapper(), id);
		System.out.println(user);
		String string = jdbcTemplate.queryForObject("select name from user1 where id=?", String.class, id);
		System.out.println(string);
		Integer integer = jdbcTemplate.queryForObject("select count(*) from user1", Integer.class);
		System.out.println(integer);

		List<String> list = jdbcTemplate.queryForList("select name from user1", String.class);
		System.out.println(list.toString());
		return user;
	}

}
