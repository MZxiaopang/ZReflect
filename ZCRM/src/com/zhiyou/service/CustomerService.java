package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer;

public interface CustomerService {
	// 增
	void add(Customer Customer);

	// 删
	void delete(Integer id);

	// 改
	void update(Customer Customer);

	// 根据负责人员ID查
	Customer selectByUser_Id(Integer user_id);

	// 根据角色号查
	Customer selectByCustomer_id(Integer customer_id);

	// 根据员工ID查
	List<Customer> selectByCustomer_Name(String name);

	boolean selectByPhone(String phone);

	// 查询所有用户
	List<Customer> selectAll(int number, int page);

	// 查数据总数
	int selectCount();
}
