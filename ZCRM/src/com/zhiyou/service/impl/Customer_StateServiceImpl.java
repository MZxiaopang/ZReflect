package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_StateDao;
import com.zhiyou.dao.impl.Customer_StateDaoImpl;
import com.zhiyou.model.Customer_State;
import com.zhiyou.service.Customer_StateService;

public class Customer_StateServiceImpl implements Customer_StateService {
	Customer_StateDao dao = new Customer_StateDaoImpl();

	@Override
	public void add(Customer_State Customer_State) {
		// TODO Auto-generated method stub
		dao.add(Customer_State);
	}

	@Override
	public void delete(Integer Customer_State_id) {
		// TODO Auto-generated method stub
		dao.delete(Customer_State_id);
	}

	@Override
	public void update(Customer_State Customer_State) {
		// TODO Auto-generated method stub
		dao.update(Customer_State);
	}

	@Override
	public List<Customer_State> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public Customer_State selectByCustomer_State_Id(Integer Customer_State_Id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_State_Id(Customer_State_Id);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
