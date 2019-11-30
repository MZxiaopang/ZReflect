package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.NoticeDao;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public void add(Notice Notice) {
		// TODO Auto-generated method stub
		String sql = "insert into Notice(pub_time,expire_time,subject,receive_id,text,creater,create_time) values(?,?,?,?,?,?,?) ";
		JDBCUtil.dbDML(sql, Notice.getPub_time(), Notice.getExpire_time(), Notice.getSubject(), Notice.getReceive_id(),
				Notice.getText(), Notice.getCreater(), Notice.getCreate_time());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from Notice where Notice_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(Notice Notice) {
		String sql = "update Notice set pub_time=?,expire_time=?,subject=?,text=?,receive_id=?,creater=?,create_time=?,updater=?,update_time=? where notice_id=?;";
		JDBCUtil.dbDML(sql, Notice.getPub_time(), Notice.getExpire_time(), Notice.getSubject(), Notice.getText(),
				Notice.getReceive_id(), Notice.getCreater(), Notice.getCreate_time(), Notice.getUpdater(),
				Notice.getUpdate_time(), Notice.getNotice_id());

	}

	@Override
	public Notice selectById(Integer id) {
		// TODO Auto-generated method stub
		List<Notice> list = JDBCUtil.dbDQL("select * from Notice where Notice_id=?", Notice.class, id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Notice selectByNotice_id(Integer Notice_id) {
		// TODO Auto-generated method stub
		List<Notice> list = JDBCUtil.dbDQL("select * from Notice where Notice_id=?", Notice.class, Notice_id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Notice> selectAll(int number, int page, User user) {
		String sql = "select *from Notice where receive_id=" + user.getDepartment_id() + " limit " + number + ","
				+ page;
		return JDBCUtil.dbDQL(sql, Notice.class);
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from Notice");
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
	public List<Notice> selectByName(String name) {
		List<Notice> list = JDBCUtil.dbDQL("select * from Notice where subject like '%" + name + "%' ", Notice.class);
		return list;
	}

	@Override
	public List<Department> selectDepartmentAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Department where status=2";
		List<Department> list = JDBCUtil.dbDQL(sql, Department.class);
		return list;
	}

	@Override
	public List<Notice> selectAll(int number, int page) {
		String sql = "select *from Notice limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, Notice.class);
	}

}
