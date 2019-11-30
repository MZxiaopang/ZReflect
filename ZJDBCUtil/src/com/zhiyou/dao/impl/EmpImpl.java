package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.EmpDAO;
import com.zhiyou.model.emp;
import com.zhiyou.util.JDBCUtil;

public class EmpImpl implements EmpDAO {

	@Override
	public void add(emp e) {
		// TODO Auto-generated method stub
		String sql = "insert into emp(empno) values(?)";
		JDBCUtil.dbDML(sql, e.getEMPNO());
	}

	@Override
	public void delete(emp e) {
		// TODO Auto-generated method stub
		String sql = "delete from emp where empno=?";
		JDBCUtil.dbDML(sql, e.getEMPNO());
	}

	@Override
	public void update(emp e) {
		// TODO Auto-generated method stub
		String sql = "update emp set ename=? where empno=?";
		JDBCUtil.dbDML(sql, e.getENAME(), e.getEMPNO());
	}

	@Override
	public List<emp> selectAll() {
		// TODO Auto-generated method stub
		return JDBCUtil.dbDQL("select *from emp", emp.class);
	}

}
