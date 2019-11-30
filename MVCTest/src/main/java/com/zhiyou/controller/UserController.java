package com.zhiyou.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
@Controller
public class UserController {

	@Autowired
	JdbcTemplate template;

	@RequestMapping("/add")
	public void add(User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		template.update("insert into user1(id,name,password,age) values(?,?,?,?) ", user.getId(), user.getName(),
				user.getPassword(), user.getAge());
		List<User> list = template.query("select *from user1", new userRowMapping());

		request.setAttribute("list", list);
//		response.sendRedirect("show.jsp");
		request.getRequestDispatcher("show.jsp").forward(request, response);

	}

	@RequestMapping("/update")
	public String update(int id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(id);
		List<User> list = template.query("select *from user1 where id=?", new userRowMapping(), id);

		System.out.println(list.toString());
		request.setAttribute("list", list.get(0));
		return "update.jsp";
	}

	@RequestMapping("/update1")
	public String Rellyupdate(User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		template.update("update user1 set name=?,password=?,age=? where id=?", user.getName(), user.getPassword(),
				user.getAge(), user.getId());

		List<User> list = template.query("select *from user1", new userRowMapping());
		request.setAttribute("list", list);

		return "show.jsp";

	}

	@RequestMapping("/delete")
	public String delete(int id, HttpServletRequest request, HttpServletResponse response) {
		template.update("delete from user1 where id=?", id);
		List<User> list = template.query("select *from user1", new userRowMapping());
		request.setAttribute("list", list);

		return "show.jsp";
	}

	class userRowMapping implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User(rs.getInt("id"), rs.getString("password"), rs.getString("name"), rs.getInt("age"));
			return user;
		}

	}

}
