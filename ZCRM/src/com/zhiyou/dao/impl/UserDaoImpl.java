package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user(create_time,creater,is_admin,username,password,department_id,role_id,is_male,mobile,age,tel,id_num,email,qq,hobby,education,address,card_num,nation,marry,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, user.getCreate_time(), user.getCreater(), user.isIs_admin(), user.getUsername(),
				user.getPassword(), user.getDepartment_id(), user.getRole_id(), user.isIs_male(), user.getMobile(),
				user.getAge(), user.getTel(), user.getId_num(), user.getEmail(), user.getQq(), user.getHobby(),
				user.getEducation(), user.getAddress(), user.getCard_num(), user.getNation(), user.getMarry(),
				user.getRemark());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where user_id=?";
		JDBCUtil.dbDML(sql, id);
	}

	@Override
	public void update(User user) {
		String sql = "update user set is_admin=?,department_id=?" + ",role_id=?,username=?,is_male=?"
				+ ",mobile=?,age=?,address=?,is_admin=?,is_system=?,password=?,tel=?,id_num=?"
				+ ",email=?,hobby=?,education=?,card_num=?,nation=?,marry=?,status=?,remark=?"
				+ ",create_time=?,creater=?,update_time=?,updater=?,qq=? where user_id=?";
		JDBCUtil.dbDML(sql, user.isIs_admin(), user.getDepartment_id(), user.getRole_id(), user.getUsername(),
				user.isIs_male(), user.getMobile(), user.getAge(), user.getAddress(), user.isIs_admin(),
				user.isIs_system(), user.getPassword(), user.getTel(), user.getId_num(), user.getEmail(),
				user.getHobby(), user.getEducation(), user.getCard_num(), user.getNation(), user.getMarry(),
				user.getStatus(), user.getRemark(), user.getCreate_time(), user.getCreater(), user.getUpdate_time(),
				user.getUpdater(), user.getQq(), user.getUser_id());

	}

	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		List<User> list = JDBCUtil.dbDQL("select * from user where user_id=?", User.class, id);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public User selectByUser_Name(String username) {
		// TODO Auto-generated method stub
		List<User> list = JDBCUtil.dbDQL("select * from user where username=?", User.class, username);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<User> selectAll(int number, int page) {
		String sql = "select *from user limit " + number + "," + page;
		return JDBCUtil.dbDQL(sql, User.class);
	}

	@Override
	public int selectCount() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from user");
			set = ps.executeQuery();
			if (set.next()) {
				count = set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, set);
		}
		return count;
	}

	@Override
	public List<User> selectByName(String name, Integer page) {
		List<User> list = JDBCUtil.dbDQL("select * from user where username like '%" + name + "%'", User.class);

		return list;
	}

	public List<User> selectByName(String name) {
		List<User> list = JDBCUtil.dbDQL("select * from user where username = ?", User.class, name);

		return list;
	}

	@Override
	public List<Role> selectRoleAll() {
		// TODO Auto-generated method stub
		String sql = "select *from Role where status=2";
		List<Role> list = JDBCUtil.dbDQL(sql, Role.class);
		return list;
	}

	@Override
	public List<Department> selectDepatmentAll() {
		String sql = "select *from department where status=2";
		List<Department> list = JDBCUtil.dbDQL(sql, Department.class);
		return list;
	}

	@Override
	public List<User> selectAll(Integer DepartmentId) {
		// TODO Auto-generated method stub
		String sql = "select *from User where Department_Id=?";
		List<User> list = JDBCUtil.dbDQL(sql, User.class, DepartmentId);
		return list;

	}

	@Override
	public List<User> selectByMobile(Long Mobile) {
		List<User> list = JDBCUtil.dbDQL("select * from user where mobile = ?", User.class, Mobile);

		return list;
	}

	@Override
	public List<User> selectById_num(Long Id_num) {
		List<User> list = JDBCUtil.dbDQL("select * from user where id_num = ?", User.class, Id_num);

		return list;
	}

	@Override
	public List<User> selectByCard_num(Long Card_num) {
		List<User> list = JDBCUtil.dbDQL("select * from user where card_num = ?", User.class, Card_num);

		return list;
	}

}
