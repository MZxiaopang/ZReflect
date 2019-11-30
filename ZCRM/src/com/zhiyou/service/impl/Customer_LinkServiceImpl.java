package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_LinkDao;
import com.zhiyou.dao.impl.Customer_LinkDaoImpl;
import com.zhiyou.model.Customer_Link;
import com.zhiyou.service.Customer_LinkService;

public class Customer_LinkServiceImpl implements Customer_LinkService {

	Customer_LinkDao dao = new Customer_LinkDaoImpl();

	@Override
	public void add(Customer_Link Customer_Link) {
		// TODO Auto-generated method stub
		dao.add(Customer_Link);
	}

	@Override
	public void delete(Integer link_id) {
		// TODO Auto-generated method stub
		dao.delete(link_id);
	}

	@Override
	public void update(Customer_Link Customer_Link) {
		// TODO Auto-generated method stub
		dao.update(Customer_Link);
	}

	@Override
	public List<Customer_Link> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public Customer_Link selectByCustomer_Link_Id(Integer link_id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_Link_Id(link_id);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
