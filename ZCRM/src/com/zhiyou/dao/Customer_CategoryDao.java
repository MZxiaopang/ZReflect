package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer_Category;

public interface Customer_CategoryDao {

	// 增
	void add(Customer_Category Customer_Category);

	// 删
	void delete(Integer customer_category_id);

	// 改
	void update(Customer_Category Customer_Category);

	// 查所有
	List<Customer_Category> selectAll(Integer number, Integer page);

	// 通过customer_category_id 客户种类ID查找
	Customer_Category selectByCustomer_Category_Id(Integer Customer_Category_Id);

	// 查数据总数
	int selectCount();
}
