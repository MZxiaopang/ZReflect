package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer_Link_Record;

public interface Customer_Link_RecordService {
	// 增
	void add(Customer_Link_Record Customer_Link_Record);

	// 删
	void delete(Integer record_id);

	// 改
	void update(Customer_Link_Record Customer_Link_Record);

	// 查所有
	List<Customer_Link_Record> selectAll(Integer number, Integer page);

	// 通过record_id ID查找
	Customer_Link_Record selectByCustomer_Link_Record_Id(Integer record_id);

	// 查数据总数
	int selectCount();
}
