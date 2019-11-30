package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserSerivceImpl;
import com.zhiyou.util.SessionKey;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserService service = new UserSerivceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = service.selectByUser_Name(request, username, password);
		if (user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute(SessionKey.USER_LOGIN, user);
			if (user.isIs_admin()) {
				request.setAttribute("Admin", "NotAdmin");
			}
			request.getRequestDispatcher("/WEB-INF/jsp/ManagerPage.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
