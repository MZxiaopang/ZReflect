package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_CategoryDao;
import com.zhiyou.dao.impl.Customer_CategoryDaoImpl;
import com.zhiyou.model.Customer_Category;
import com.zhiyou.service.Customer_CategoryService;

public class Customer_CategoryServiceImpl implements Customer_CategoryService {

	Customer_CategoryDao dao = new Customer_CategoryDaoImpl();

	@Override
	public void add(Customer_Category Customer_Category) {
		// TODO Auto-generated method stub
		dao.add(Customer_Category);
	}

	@Override
	public void delete(Integer customer_category_id) {
		// TODO Auto-generated method stub
		dao.delete(customer_category_id);
	}

	@Override
	public void update(Customer_Category Customer_Category) {
		// TODO Auto-generated method stub
		dao.update(Customer_Category);
	}

	@Override
	public List<Customer_Category> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public Customer_Category selectByCustomer_Category_Id(Integer Customer_Category_Id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_Category_Id(Customer_Category_Id);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
