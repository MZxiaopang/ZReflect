package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.DepartmentDao;
import com.zhiyou.model.Department;
import com.zhiyou.util.JDBCUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public void add(Department Department) {
		// TODO Auto-generated method stub
		String sql = "insert into Department(department_name,remark,creater,create_time) values(?,?,?,?) ";
		JDBCUtil.dbDML(sql, Department.getDepartment_name(), Department.getRemark(), Department.getCreater(),
				Department.getCreate_time());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from Department where department_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(Department Department) {
		String sql = "update Department set Department_name=? , remark=?,creater=?,create_time=?,updater=?,update_time=? where Department_id=?";
		JDBCUtil.dbDML(sql, Department.getDepartment_name(), Department.getRemark(), Department.getCreater(),
				Department.getCreate_time(), Department.getUpdater(), Department.getUpdate_time(),
				Department.getDepartment_id());
	}

	@Override
	public Department selectById(Integer id) {
		// TODO Auto-generated method stub
		List<Department> list = JDBCUtil.dbDQL("select * from Department where Department_id=?", Department.class, id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Department selectByDepartment_id(String Department_id) {
		// TODO Auto-generated method stub
		List<Department> list = JDBCUtil.dbDQL("select * from Department where Department_id=?", Department.class,
				Department_id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Department> selectAll(int number, int page) {
		String sql = "select *from Department limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, Department.class);
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from Department");
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
	public List<Department> selectByName(String name) {
		List<Department> list = JDBCUtil.dbDQL("select * from Department where Department_name like '%" + name + "%' ",
				Department.class);

		return list;
	}

	public List<Department> selectBy_Name(String name) {
		String sql = "select *from  Department where Department_name=?";
		List<Department> list = JDBCUtil.dbDQL(sql, Department.class, name);
		return list;

	}

}
