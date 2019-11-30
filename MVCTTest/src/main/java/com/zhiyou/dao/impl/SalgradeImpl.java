package com.zhiyou.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhiyou.dao.SalgradeDao;
import com.zhiyou.model.Salgrade;

@Repository
public class SalgradeImpl implements SalgradeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void add(Salgrade Salgrade) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into Salgrade(GRADE,LOSAL,HISAL) values(?,?,?)", Salgrade.getGRADE(),
				Salgrade.getLOSAL(), Salgrade.getHISAL());
	}

	public void update(Salgrade Salgrade) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update salgrade set losal=?,hisal=? where grade=?", Salgrade.getLOSAL(),
				Salgrade.getHISAL(), Salgrade.getGRADE());
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from Salgrade where GRADE=?", id);
	}

	public List<Salgrade> selectAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from Salgrade", new salgradeRowMapping());
	}

	public List<Salgrade> selectByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from Salgrade", new salgradeRowMapping(), name);
	}

	public Salgrade selectById(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select *from Salgrade where GRADE=?", new salgradeRowMapping(), id).get(0);
	}

	class salgradeRowMapping implements RowMapper<Salgrade> {

		public Salgrade mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Salgrade salgrade = new Salgrade(rs.getInt("GRADE"), rs.getInt("LOSAL"), rs.getInt("HISAL"));
			return salgrade;
		}

	}

}
