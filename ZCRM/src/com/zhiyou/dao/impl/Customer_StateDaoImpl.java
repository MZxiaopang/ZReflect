package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.Customer_StateDao;
import com.zhiyou.model.Customer_State;
import com.zhiyou.util.JDBCUtil;

public class Customer_StateDaoImpl implements Customer_StateDao {

	@Override
	public void add(Customer_State Customer_State) {
		// TODO Auto-generated method stub
		String sql = "insert into Customer_State values(null,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, Customer_State.getCustomer_state_name(), Customer_State.getCustomer_state_desc(),
				Customer_State.getStatus(), Customer_State.getRemark(), Customer_State.getCreate_time(),
				Customer_State.getCreater(), Customer_State.getUpdate_time(), Customer_State.getUpdater());
	}

	@Override
	public void delete(Integer Customer_State_id) {
		// TODO Auto-generated method stub
		String sql = "delete from Customer_State where Customer_State_id=?";
		JDBCUtil.dbDML(sql, Customer_State_id);
	}

	@Override
	public void update(Customer_State Customer_State) {
		// TODO Auto-generated method stub
		String sql = "update Customer_State set Customer_State_name=?,Customer_State_desc=?,status=?,remark=?,create_time=?,creater=?,update_time=?,updater=? where Customer_State_id=?";
		JDBCUtil.dbDML(sql, Customer_State.getCustomer_state_name(), Customer_State.getCustomer_state_desc(),
				Customer_State.getStatus(), Customer_State.getRemark(), Customer_State.getCreate_time(),
				Customer_State.getCreater(), Customer_State.getUpdate_time(), Customer_State.getUpdater(),
				Customer_State.getCustomer_state_id());
	}

	@Override
	public List<Customer_State> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		String sql = "select *from Customer_State limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, Customer_State.class);
	}

	@Override
	public Customer_State selectByCustomer_State_Id(Integer Customer_State_Id) {
		// TODO Auto-generated method stub
		String sql = "select *from Customer_State where Customer_State_id=?";
		return JDBCUtil.dbDQL(sql, Customer_State.class, Customer_State_Id).get(0);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from Customer_State";
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
