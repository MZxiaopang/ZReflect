package com.zhiyou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhiyou.dao.DeptDao;
import com.zhiyou.model.Dept;

@Repository
public class DeptImpl implements DeptDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(Dept Dept) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into dept(DEPTION,DNAME,LOC) values(?,?,?)", Dept.getDEPTION(), Dept.getDNAME(),
				Dept.getLOC());
	}

	public void update(Dept Dept) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update dept set dname=?,loc=? where deption=?", Dept.getDNAME(), Dept.getLOC(),
				Dept.getDEPTION());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from dept where DEPTION=?", id);
	}

	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from Dept", new deptRowMapping());
	}

	public List<Dept> selectByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from Dept where dname=?", new deptRowMapping(), name);
	}

	public Dept selectById(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from Dept where deption=?", new deptRowMapping(), id).get(0);
	}

	class deptRowMapping implements RowMapper<Dept> {

		public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Dept dept = new Dept(rs.getInt("DEPTION"), rs.getString("DNAME"), rs.getString("LOC"));
			return dept;
		}

	}

}
