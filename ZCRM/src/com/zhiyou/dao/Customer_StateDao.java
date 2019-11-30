package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer_State;

public interface Customer_StateDao {
	// 增
	void add(Customer_State Customer_State);

	// 删
	void delete(Integer Customer_State_id);

	// 改
	void update(Customer_State Customer_State);

	// 查所有
	List<Customer_State> selectAll(Integer number, Integer page);

	// 通过Customer_State_id 客户种类ID查找
	Customer_State selectByCustomer_State_Id(Integer Customer_State_Id);

	// 查数据总数
	int selectCount();
}
