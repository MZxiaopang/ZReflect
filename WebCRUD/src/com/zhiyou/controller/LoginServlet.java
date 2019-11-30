package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;
import com.zhiyou.util.SessionKey;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Cookie[] cookies = req.getCookies();
//		if (cookies.length > 0) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("c")) {
//					resp.sendRedirect("show?service=show");
//					return;
//				}
//			}
//		}
//
//		Cookie c = new Cookie("c", "张三");
//		c.setMaxAge(0);
//		c.setPath("/");
//		resp.addCookie(c);
//		req.getSession().setAttribute("", "");

		Cookie cookie = new Cookie("c", "张三");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);

		String name = req.getParameter("username") != null ? req.getParameter("username") : "";
		String password = req.getParameter("password") != null ? req.getParameter("password") : "";

		UserService service = new UserServiceImpl();
		User user = service.selectaByUserName(req, name, password);
		if (user == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute(SessionKey.USER_LOGIN, user);
			resp.sendRedirect("show?service=show");
		}
	}
}
