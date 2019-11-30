package com.zhiyou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhiyou.dao.EmpDao;
import com.zhiyou.model.Emp;

@Repository
public class EmpImpl implements EmpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(Emp Emp) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values(?,?,?,?,?,?,?,?)",
				Emp.getEMPNO(), Emp.getENAME(), Emp.getJOB(), Emp.getMGR(), Emp.getHIREDATE(), Emp.getSAL(),
				Emp.getCOMM(), Emp.getDEPTNO());
	}

	public void update(Emp Emp) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update emp set ENAME=?,JOB=?,MGR=?,HIREDATE=?,SAL=?,COMM=?,DEPTNO=? where EMPNO=?",
				Emp.getENAME(), Emp.getJOB(), Emp.getMGR(), Emp.getHIREDATE(), Emp.getSAL(), Emp.getCOMM(),
				Emp.getDEPTNO(), Emp.getEMPNO());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from emp where EMPNO=?", id);
	}

	public List<Emp> selectAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from emp", new empRowMapping());
	}

	public List<Emp> selectByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from emp ENAME=?", new empRowMapping(), name);
	}

	public Emp selectById(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from emp where EMPNO=?", new empRowMapping(), id).get(0);
	}

	class empRowMapping implements RowMapper<Emp> {

		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Emp emp = new Emp(rs.getInt("EMPNO"), rs.getString("ENAME"), rs.getString("JOB"), rs.getInt("MGR"),
					rs.getDate("HIREDATE"), rs.getInt("SAL"), rs.getInt("COMM"), rs.getInt("DEPTNO"));
			return emp;
		}

	}

}
