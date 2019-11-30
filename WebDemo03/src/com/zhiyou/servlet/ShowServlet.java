package com.zhiyou.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;
import com.zhiyou.model.User;

public class ShowServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDaoImpl();
		List<User> list = dao.selectAll();
		// 把数据传授到当前请求 key 为名称 value是实际传送的值
		req.setAttribute("list", list);

		// 从请求域中取出数据 获得setAttribute传递的数据
		System.out.println(req.getAttribute("user"));

		// 从会话域中取出数据
		System.out.println(req.getSession().getAttribute("user"));
		// 从应用域中获取数据
		System.out.println(req.getSession().getServletContext().getAttribute("user"));
		req.getRequestDispatcher("WEB-INF/show.jsp").forward(req, resp);
//		resp.sendRedirect("WEB-INF/show.html");

	}
}
