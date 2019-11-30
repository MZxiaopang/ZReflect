package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer_Care;

public interface Customer_CareDao {
	// 增
	void add(Customer_Care Customer_Care);

	// 删
	void delete(Integer id);

	// 改
	void update(Customer_Care Customer_Care);

	// 根据客户ID查
	Customer_Care selectByCustomer_id(Integer user_id);

	// 根据客户关怀ID查
	Customer_Care selectByCustomer_Care_id(Integer customer_id);

	// 查询所有关怀客户
	List<Customer_Care> selectAll(int number, int page);

	// 查数据总数
	int selectCount();
}
