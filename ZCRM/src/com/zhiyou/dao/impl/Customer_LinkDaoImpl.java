package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.Customer_LinkDao;
import com.zhiyou.model.Customer_Link;
import com.zhiyou.util.JDBCUtil;

public class Customer_LinkDaoImpl implements Customer_LinkDao {

	@Override
	public void add(Customer_Link Customer_Link) {
		// TODO Auto-generated method stub
		String sql = "insert into Customer_Link values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, Customer_Link.getCustomer_id(), Customer_Link.getLink_name(),
				Customer_Link.getLink_is_male(), Customer_Link.getLink_position(), Customer_Link.getLink_mobile(),
				Customer_Link.getLink_age(), Customer_Link.getLink_relation(), Customer_Link.getStatus(),
				Customer_Link.getRemark(), Customer_Link.getNext_time(), Customer_Link.getCreate_time(),
				Customer_Link.getCreater(), Customer_Link.getUpdate_time(), Customer_Link.getUpdater());
	}

	@Override
	public void delete(Integer link_id) {
		// TODO Auto-generated method stub

		String sql = "delete from Customer_Link where link_id=?";
		JDBCUtil.dbDML(sql, link_id);
	}

	@Override
	public void update(Customer_Link Customer_Link) {
		// TODO Auto-generated method stub
		String sql = "update Customer_Link set customer_id=?,link_name=?,link_is_male=?,link_position=?,link_mobile=?,link_age=?,link_relation=?,status=?,remark=?,next_time=?,create_time=?,creater=?,update_time=?,updater=?  where link_id=?";
		JDBCUtil.dbDML(sql, Customer_Link.getCustomer_id(), Customer_Link.getLink_name(),
				Customer_Link.getLink_is_male(), Customer_Link.getLink_position(), Customer_Link.getLink_mobile(),
				Customer_Link.getLink_age(), Customer_Link.getLink_relation(), Customer_Link.getStatus(),
				Customer_Link.getRemark(), Customer_Link.getNext_time(), Customer_Link.getCreate_time(),
				Customer_Link.getCreater(), Customer_Link.getUpdate_time(), Customer_Link.getUpdater(),
				Customer_Link.getLink_id());
	}

	@Override
	public List<Customer_Link> selectAll(Integer number, Integer page) {
		String sql = "select * from Customer_Link limit " + number + "," + page;
		List<Customer_Link> list = JDBCUtil.dbDQL(sql, Customer_Link.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public Customer_Link selectByCustomer_Link_Id(Integer link_id) {
		String sql = "select * from Customer_Link where link_id=?";
		List<Customer_Link> list = JDBCUtil.dbDQL(sql, Customer_Link.class, link_id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from Customer_Link");
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
