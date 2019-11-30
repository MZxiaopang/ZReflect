package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;

public class ShowServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		req.setAttribute("msg", "request的信息");
//		req.getSession().setAttribute("msg", "session的信息");
//		req.getSession().getServletContext().setAttribute("msg", "应用域的信息");
//		req.setAttribute("age", 109);
		UserDao dao = new UserDaoImpl();
		req.setAttribute("list", dao.selectAll());

		req.getRequestDispatcher("WEB-INF/show.jsp").forward(req, resp);

	}
}
