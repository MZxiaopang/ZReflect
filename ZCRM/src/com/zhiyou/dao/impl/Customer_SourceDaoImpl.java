package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.Customer_SourceDao;
import com.zhiyou.model.Customer_Source;
import com.zhiyou.util.JDBCUtil;

public class Customer_SourceDaoImpl implements Customer_SourceDao {

	@Override
	public void add(Customer_Source Customer_Source) {
		// TODO Auto-generated method stub
		String sql = "insert into Customer_Source values(null,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, Customer_Source.getCustomer_source_name(), Customer_Source.getCustomer_source_desc(),
				Customer_Source.getStatus(), Customer_Source.getRemark(), Customer_Source.getCreate_time(),
				Customer_Source.getCreater(), Customer_Source.getUpdate_time(), Customer_Source.getUpdater());
	}

	@Override
	public void delete(Integer Customer_Source_id) {
		// TODO Auto-generated method stub
		String sql = "delete from Customer_Source where customer_source_id=?";
		JDBCUtil.dbDML(sql, Customer_Source_id);
	}

	@Override
	public void update(Customer_Source Customer_Source) {
		// TODO Auto-generated method stub
		String sql = "update Customer_Source set customer_source_name=?,customer_source_desc=?,status=?,remark=?,create_time=?,creater=?,update_time=?,updater=? where customer_source_id=?";
		JDBCUtil.dbDML(sql, Customer_Source.getCustomer_source_name(), Customer_Source.getCustomer_source_desc(),
				Customer_Source.getStatus(), Customer_Source.getRemark(), Customer_Source.getCreate_time(),
				Customer_Source.getCreater(), Customer_Source.getUpdate_time(), Customer_Source.getUpdater(),
				Customer_Source.getCustomer_source_id());
	}

	@Override
	public List<Customer_Source> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		String sql = "select *from Customer_Source limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, Customer_Source.class);
	}

	@Override
	public Customer_Source selectByCustomer_Source_Id(Integer Customer_Source_Id) {
		// TODO Auto-generated method stub
		String sql = "select *from Customer_Source where customer_source_id=?";
		return JDBCUtil.dbDQL(sql, Customer_Source.class, Customer_Source_Id).get(0);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from Customer_Source";
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
