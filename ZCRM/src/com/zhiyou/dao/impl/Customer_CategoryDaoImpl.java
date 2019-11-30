package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.Customer_CategoryDao;
import com.zhiyou.model.Customer_Category;
import com.zhiyou.util.JDBCUtil;

public class Customer_CategoryDaoImpl implements Customer_CategoryDao {

	@Override
	public void add(Customer_Category Customer_Category) {
		// TODO Auto-generated method stub
		String sql = "insert into customer_category values(null,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, Customer_Category.getCustomer_category_name(),
				Customer_Category.getCustomer_category_desc(), Customer_Category.getStatus(),
				Customer_Category.getRemark(), Customer_Category.getCreate_time(), Customer_Category.getCreater(),
				Customer_Category.getUpdate_time(), Customer_Category.getUpdater());
	}

	@Override
	public void delete(Integer customer_category_id) {
		// TODO Auto-generated method stub
		String sql = "delete from Customer_Category where customer_category_id=?";
		JDBCUtil.dbDML(sql, customer_category_id);
	}

	@Override
	public void update(Customer_Category Customer_Category) {
		String sql = "update Customer_Category set customer_category_name=?,customer_category_desc=?,status=?,remark=?,create_time=?,creater=?,update_time=?,updater=? where customer_category_id=?";
		JDBCUtil.dbDML(sql, Customer_Category.getCustomer_category_name(),
				Customer_Category.getCustomer_category_desc(), Customer_Category.getStatus(),
				Customer_Category.getRemark(), Customer_Category.getCreate_time(), Customer_Category.getCreater(),
				Customer_Category.getUpdate_time(), Customer_Category.getUpdater(),
				Customer_Category.getCustomer_category_id());
	}

	@Override
	public List<Customer_Category> selectAll(Integer number, Integer page) {
		String sql = "select *from Customer_Category limit " + number + "," + page;
		List<Customer_Category> list = JDBCUtil.dbDQL(sql, Customer_Category.class);
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public Customer_Category selectByCustomer_Category_Id(Integer Customer_Category_Id) {
		// TODO Auto-generated method stub
		String sql = "select *from Customer_Category where customer_category_id=?";
		List<Customer_Category> list = JDBCUtil.dbDQL(sql, Customer_Category.class, Customer_Category_Id);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from Customer_Category";
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
