package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;
import com.zhiyou.model.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username") != null ? req.getParameter("username") : " ";
		String password = req.getParameter("password");
		UserDao dao = new UserDaoImpl();
		User user = dao.selectByUserName(username);
		if (user != null) {

			if (user.getPassword().equals(password)) {

				System.out.println("登陆成功");
				// 往请求域中存放数据
//				req.setAttribute("user", user);
				// 往会话域中存放数据
//				req.getSession().setAttribute("user", user);
				// 往应用域中存放对象
//				req.getSession().getServletContext().setAttribute("user", user);
//				req.getSession().getServletContext().removeAttribute("user");
				// req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
				req.getRequestDispatcher("show").forward(req, resp);

//				resp.sendRedirect("show");
				return;
			} else {
				req.setAttribute("msg", "密码错误");

			}
		} else {
			req.setAttribute("msg", "账户不存在");

		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
