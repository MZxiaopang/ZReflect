package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.CustomerDao;
import com.zhiyou.model.Customer;
import com.zhiyou.util.JDBCUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, customer.getCustomer_state_id(), customer.getCustomer_source_id(), customer.getUser_id(),
				customer.getCustomer_category_id(), customer.getCustomer_name(), customer.getCustomer_is_male(),
				customer.getCustomer_mobile(), customer.getCustomer_qq(), customer.getCustomer_address(),
				customer.getCustomer_email(), customer.getCustomer_remark(), customer.getCustomer_position(),
				customer.getCustomer_blog(), customer.getCustomer_tel(), customer.getCustomer_birth(),
				customer.getCustomer_company(), customer.getStatus(), customer.getRemark(), customer.getCreate_time(),
				customer.getCreater(), customer.getUpdate_time(), customer.getUpdater());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from customer where customer_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "update customer set customer_state_id=?,customer_source_id=?,user_id=?,customer_category_id=?,customer_name=?,customer_is_male=?,customer_mobile=?,customer_qq=?,customer_address=?,customer_email=?,customer_remark=?,customer_position=?,customer_blog=?,customer_tel=?,customer_birth=?,customer_company=?,status=?,remark=?,create_time=?,creater=?,update_time=?,updater=?  where customer_id=?";
		JDBCUtil.dbDML(sql, customer.getCustomer_state_id(), customer.getCustomer_source_id(), customer.getUser_id(),
				customer.getCustomer_category_id(), customer.getCustomer_name(), customer.getCustomer_is_male(),
				customer.getCustomer_mobile(), customer.getCustomer_qq(), customer.getCustomer_address(),
				customer.getCustomer_email(), customer.getCustomer_remark(), customer.getCustomer_position(),
				customer.getCustomer_blog(), customer.getCustomer_tel(), customer.getCustomer_birth(),
				customer.getCustomer_company(), customer.getStatus(), customer.getRemark(), customer.getCreate_time(),
				customer.getCreater(), customer.getUpdate_time(), customer.getUpdater(), customer.getCustomer_id());
	}

	@Override
	public Customer selectByUser_Id(Integer user_id) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where user_id=?";
		List<Customer> list = JDBCUtil.dbDQL(sql, Customer.class, user_id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Override
	public Customer selectByCustomer_id(Integer customer_id) {
		String sql = "select * from customer where customer_id=?";
		List<Customer> list = JDBCUtil.dbDQL(sql, Customer.class, customer_id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<Customer> selectByCustomer_Name(String name) {
		String sql = "select * from customer where name=?";
		List<Customer> list = JDBCUtil.dbDQL(sql, Customer.class, name);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<Customer> selectAll(int number, int page) {
		String sql = "select * from customer limit " + number + "," + page;
		List<Customer> list = JDBCUtil.dbDQL(sql, Customer.class);
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
			ps = conn.prepareStatement("select count(*) from customer");
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
	public List<Customer> selectByPhone(String phone) {
		// TODO Auto-generated method stub
		String sql = "select *from Customer where customer_mobile=?";
		List<Customer> list = JDBCUtil.dbDQL(sql, Customer.class, phone);
		return list;
	}

}
