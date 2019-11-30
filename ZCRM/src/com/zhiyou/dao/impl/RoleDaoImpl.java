package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.RoleDao;
import com.zhiyou.model.Role;
import com.zhiyou.util.JDBCUtil;

public class RoleDaoImpl implements RoleDao {

	@Override
	public void add(Role Role) {
		// TODO Auto-generated method stub
		String sql = "insert into role(role_name,remark,creater,create_time) values(?,?,?,?) ";
		JDBCUtil.dbDML(sql, Role.getRole_name(), Role.getRemark(), Role.getCreater(), Role.getCreate_time());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from Role where Role_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(Role Role) {
		String sql = "update role set role_name=? , remark=?,create_time=?,creater=?,updater=?,update_time=? where role_id=?";
		JDBCUtil.dbDML(sql, Role.getRole_name(), Role.getRemark(), Role.getCreate_time(), Role.getCreater(),
				Role.getUpdater(), Role.getUpdate_time(), Role.getRole_id());
	}

	@Override
	public Role selectById(Integer id) {
		// TODO Auto-generated method stub
		List<Role> list = JDBCUtil.dbDQL("select * from Role where Role_id=?", Role.class, id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Role selectByRole_id(String role_id) {
		// TODO Auto-generated method stub
		List<Role> list = JDBCUtil.dbDQL("select * from Role where role_id=?", Role.class, role_id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Role> selectAll(int number, int page) {
		String sql = "select *from Role limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, Role.class);
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from Role");
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

	@Override
	public List<Role> selectByName(String name, Integer page) {
		List<Role> list = JDBCUtil
				.dbDQL("select * from Role where Role_name like '%" + name + "%' limit " + page + ",5", Role.class);

		return list;
	}

	@Override
	public List<Role> selectByName(String name) {
		String sql = "select *from role where role_name=?";
		List<Role> list = JDBCUtil.dbDQL(sql, Role.class, name);
		return list;
	}

}
