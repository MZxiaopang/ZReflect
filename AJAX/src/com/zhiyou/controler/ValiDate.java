package com.zhiyou.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;

/**
 * Servlet implementation class ValiDate
 */
@WebServlet("/valiDate")
public class ValiDate extends HttpServlet {
	UserDao dao = new UserDaoImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("@@" + name);
		boolean b = dao.selectByName(name);
		System.out.println(b + "");
		resp.getWriter().write(b + "");

	}

}
