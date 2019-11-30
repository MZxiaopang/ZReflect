package com.zhiyou.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectaByUserName(String username) {
		List<User> list = JDBCUtil.dbDQL("select *from user1 where name=?", User.class, username);

		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<User> selectAll(int number, int page) {
		String sql = "select *from user1 limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, User.class);
	}

	@Override
	public void add(User user) {
		JDBCUtil.dbDML("insert into user1 values(null,?,?,?)", user.getPassword(), user.getName(), user.getAge());
	}

	@Override
	public void delectById(Integer id) {
		// TODO Auto-generated method stub
		JDBCUtil.dbDML("delete from user1 where id=?", id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		JDBCUtil.dbDML("update user1 set password=?,name=?,age=? where id=?", user.getPassword(), user.getName(),
				user.getAge(), user.getId());

	}

	@Override
	public User selectaById(Integer id) {
		// TODO Auto-generated method stub
		return JDBCUtil.dbDQL("select * from user1 where id=?", User.class, id).get(0);
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from user1");
			set = ps.executeQuery();
			if (set.next()) {
				count = set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, set);
		}
		return count;
	}

}
