package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.CustomerDao;
import com.zhiyou.dao.impl.CustomerDaoImpl;
import com.zhiyou.model.Customer;
import com.zhiyou.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao dao = new CustomerDaoImpl();

	@Override
	public void add(Customer Customer) {
		// TODO Auto-generated method stub
		dao.add(Customer);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Customer Customer) {
		// TODO Auto-generated method stub
		dao.update(Customer);
	}

	@Override
	public Customer selectByUser_Id(Integer user_id) {
		// TODO Auto-generated method stub
		return dao.selectByUser_Id(user_id);
	}

	@Override
	public Customer selectByCustomer_id(Integer customer_id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_id(customer_id);
	}

	@Override
	public List<Customer> selectByCustomer_Name(String name) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_Name(name);
	}

	@Override
	public List<Customer> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public boolean selectByPhone(String phone) {
		// TODO Auto-generated method stub
		List<Customer> list = dao.selectByPhone(phone);
		if (list.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

}
