package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_SourceDao;
import com.zhiyou.dao.impl.Customer_SourceDaoImpl;
import com.zhiyou.model.Customer_Source;
import com.zhiyou.service.Customer_SourceService;

public class Customer_SourceServiceImpl implements Customer_SourceService {

	Customer_SourceDao dao = new Customer_SourceDaoImpl();

	@Override
	public void add(Customer_Source Customer_Source) {
		// TODO Auto-generated method stub
		dao.add(Customer_Source);
	}

	@Override
	public void delete(Integer Customer_Source_id) {
		// TODO Auto-generated method stub
		dao.delete(Customer_Source_id);
	}

	@Override
	public void update(Customer_Source Customer_Source) {
		// TODO Auto-generated method stub
		dao.update(Customer_Source);
	}

	@Override
	public List<Customer_Source> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public Customer_Source selectByCustomer_Source_Id(Integer Customer_Source_Id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_Source_Id(Customer_Source_Id);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
