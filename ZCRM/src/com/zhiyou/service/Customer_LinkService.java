package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer_Link;

public interface Customer_LinkService {
	// 增
	void add(Customer_Link Customer_Link);

	// 删
	void delete(Integer link_id);

	// 改
	void update(Customer_Link Customer_Link);

	// 查所有
	List<Customer_Link> selectAll(Integer number, Integer page);

	// 通过联系人ID查找
	Customer_Link selectByCustomer_Link_Id(Integer link_id);

	// 查数据总数
	int selectCount();
}
