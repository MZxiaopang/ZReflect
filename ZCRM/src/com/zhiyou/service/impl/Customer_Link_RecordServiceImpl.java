package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.Customer_Link_RecordDao;
import com.zhiyou.dao.impl.Customer_Link_RecordDaoImpl;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.service.Customer_Link_RecordService;

public class Customer_Link_RecordServiceImpl implements Customer_Link_RecordService {
	Customer_Link_RecordDao dao = new Customer_Link_RecordDaoImpl();

	@Override
	public void add(Customer_Link_Record Customer_Link_Record) {
		// TODO Auto-generated method stub
		dao.add(Customer_Link_Record);
	}

	@Override
	public void delete(Integer record_id) {
		// TODO Auto-generated method stub
		dao.delete(record_id);
	}

	@Override
	public void update(Customer_Link_Record Customer_Link_Record) {
		// TODO Auto-generated method stub
		dao.update(Customer_Link_Record);
	}

	@Override
	public List<Customer_Link_Record> selectAll(Integer number, Integer page) {
		// TODO Auto-generated method stub
		return dao.selectAll(number, page);
	}

	@Override
	public Customer_Link_Record selectByCustomer_Link_Record_Id(Integer record_id) {
		// TODO Auto-generated method stub
		return dao.selectByCustomer_Link_Record_Id(record_id);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
