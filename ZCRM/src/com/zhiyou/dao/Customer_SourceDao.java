package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer_Source;

public interface Customer_SourceDao {

	// 增
	void add(Customer_Source Customer_Source);

	// 删
	void delete(Integer Customer_Source_id);

	// 改
	void update(Customer_Source Customer_Source);

	// 查所有
	List<Customer_Source> selectAll(Integer number, Integer page);

	// 通过Customer_Source_id 客户种类ID查找
	Customer_Source selectByCustomer_Source_Id(Integer Customer_Source_Id);

	// 查数据总数
	int selectCount();
}
