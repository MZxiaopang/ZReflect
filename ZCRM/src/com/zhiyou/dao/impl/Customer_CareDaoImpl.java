package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.Customer_CareDao;
import com.zhiyou.model.Customer_Care;
import com.zhiyou.util.JDBCUtil;

public class Customer_CareDaoImpl implements Customer_CareDao {

	@Override
	public void add(Customer_Care customer_Care) {
		// TODO Auto-generated method stub
		String sql = "insert into Customer_Care values(null,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, customer_Care.getCustomer_id(), customer_Care.getCare_subject(),
				customer_Care.getCare_type(), customer_Care.getStatus(), customer_Care.getRemark(),
				customer_Care.getNext_time(), customer_Care.getCreate_time(), customer_Care.getCreater(),
				customer_Care.getUpdate_time(), customer_Care.getUpdater());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from customer_Care where customer_care_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(Customer_Care customer_Care) {
		String sql = "update customer_Care set customer_id=?,care_subject=?,care_type=?,status=?,remark=?,next_time=?,create_time=?,creater=?,update_time=?,updater=? where customer_care_id=? ";
		JDBCUtil.dbDML(sql, customer_Care.getCustomer_id(), customer_Care.getCare_subject(),
				customer_Care.getCare_type(), customer_Care.getStatus(), customer_Care.getRemark(),
				customer_Care.getNext_time(), customer_Care.getCreate_time(), customer_Care.getCreater(),
				customer_Care.getUpdate_time(), customer_Care.getUpdater(), customer_Care.getCustomer_care_id());

	}

	@Override
	public Customer_Care selectByCustomer_id(Integer Customer_id) {
		String sql = "select * from Customer_Care where Customer_id=?";
		List<Customer_Care> list = JDBCUtil.dbDQL(sql, Customer_Care.class, Customer_id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public Customer_Care selectByCustomer_Care_id(Integer Customer_Care_id) {
		String sql = "select * from Customer_Care where Customer_Care_id=?";
		List<Customer_Care> list = JDBCUtil.dbDQL(sql, Customer_Care.class, Customer_Care_id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<Customer_Care> selectAll(int number, int page) {
		String sql = "select * from Customer_Care limit " + number + "," + page;
		List<Customer_Care> list = JDBCUtil.dbDQL(sql, Customer_Care.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from Customer_Care");
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
