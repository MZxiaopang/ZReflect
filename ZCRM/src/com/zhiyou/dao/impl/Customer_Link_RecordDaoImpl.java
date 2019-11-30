package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.Customer_Link_RecordDao;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.util.JDBCUtil;

public class Customer_Link_RecordDaoImpl implements Customer_Link_RecordDao {

	@Override
	public void add(Customer_Link_Record Customer_Link_Record) {
		// TODO Auto-generated method stub
		String sql = "insert into customer_link_record values(null,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, Customer_Link_Record.getCustomer_id(), Customer_Link_Record.getLink_type(),
				Customer_Link_Record.getLink_subject(), Customer_Link_Record.getLink_nexttime(),
				Customer_Link_Record.getStatus(), Customer_Link_Record.getRemark(), Customer_Link_Record.getNext_time(),
				Customer_Link_Record.getCreate_time(), Customer_Link_Record.getCreater(),
				Customer_Link_Record.getUpdate_time(), Customer_Link_Record.getUpdater());
	}

	@Override
	public void delete(Integer record_id) {
		// TODO Auto-generated method stub
		String sql = "delete from Customer_Link_Record where record_id=?";
		JDBCUtil.dbDML(sql, record_id);
	}

	@Override
	public void update(Customer_Link_Record Customer_Link_Record) {
		// TODO Auto-generated method stub
		String sql = "update Customer_Link_Record set customer_id=?,link_type=?,link_subject=?,link_nexttime=?,status=?,remark=?,next_time=?,create_time=?,creater=?,update_time=?,updater=? where record_id=?";
		JDBCUtil.dbDML(sql, Customer_Link_Record.getCustomer_id(), Customer_Link_Record.getLink_type(),
				Customer_Link_Record.getLink_subject(), Customer_Link_Record.getLink_nexttime(),
				Customer_Link_Record.getStatus(), Customer_Link_Record.getRemark(), Customer_Link_Record.getNext_time(),
				Customer_Link_Record.getCreate_time(), Customer_Link_Record.getCreater(),
				Customer_Link_Record.getUpdate_time(), Customer_Link_Record.getUpdater(),
				Customer_Link_Record.getRecord_id());
	}

	@Override
	public List<Customer_Link_Record> selectAll(Integer number, Integer page) {
		String sql = "select *from Customer_Link_Record limit " + number + "," + page;
		List<Customer_Link_Record> list = JDBCUtil.dbDQL(sql, Customer_Link_Record.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public Customer_Link_Record selectByCustomer_Link_Record_Id(Integer record_id) {
		String sql = "select *from Customer_Link_Record where record_id=?";
		List<Customer_Link_Record> list = JDBCUtil.dbDQL(sql, Customer_Link_Record.class, record_id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from Customer_Link_Record";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
