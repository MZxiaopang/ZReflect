package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String string = req.getParameter("id");
		UserDao dao = new UserDaoImpl();
		dao.deleteById(Integer.valueOf(string));
		resp.sendRedirect("show");
	}
}
