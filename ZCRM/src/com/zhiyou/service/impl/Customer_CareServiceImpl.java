package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_CareDao;
import com.zhiyou.dao.impl.Customer_CareDaoImpl;
import com.zhiyou.model.Customer_Care;
import com.zhiyou.service.Customer_CareService;

public class Customer_CareServiceImpl implements Customer_CareService {

	Customer_CareDao dao = new Customer_CareDaoImpl();

	@Override
	public void add(Customer_Care Customer_Care) {
		// TODO Auto-generated method stub
		dao.add(Customer_Care);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Customer_Care Customer_Care) {
		// TODO Auto-generated method stub
		dao.update(Customer_Care);
	}

	@Override
	public Customer_Care selectByCustomer_id(Integer Customer_id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_id(Customer_id);
	}

	@Override
	public Customer_Care selectByCustomer_Care_id(Integer Customer_Care_id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_Care_id(Customer_Care_id);
	}

	@Override
	public List<Customer_Care> selectAll(int number, int page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
