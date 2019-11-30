package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.user.UserDaoImpl;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

public class ShowServlet extends HttpServlet {

	private static UserService service = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("service");
		System.out.println(string);
		if (string.equals("show")) {
			show(req, resp);
		}
		if (string.equals("delete")) {
			delete(req, resp);
		}
		if (string.equals("alter")) {
			System.out.println("alter");
			alter(req, resp);
		}
		if (string.equals("update")) {
			update(req, resp);
		}
		if (string.equals("add")) {
			add(req, resp);
		}
	}

	private static void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int count = service.selectCount();

		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		req.setAttribute("page", page);
		req.setAttribute("count", count);
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		req.getRequestDispatcher("/WEB-INF/jsp/show.jsp").forward(req, resp);
	}

	private static void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Cookie[] cookies = req.getCookies();
//		for (Cookie cookie : cookies) {
//			if (cookie.getName().equals("cookie")) {
//				cookie.setValue("李四");
//				cookie.setMaxAge(0);
//				resp.addCookie(cookie);
//			}
//		}

		req.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(req, resp);
	}

	private static void alter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1111");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		UserDao dao = new UserDaoImpl();
		if (id == null) {
			User user = new User(password, name, Integer.valueOf(age));
			service.add(user);
		} else {
			User user = new User(Integer.valueOf(id), password, name, Integer.valueOf(age));
			service.update(user);
		}
		resp.sendRedirect("show?service=show");
	}

	private static void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("user", service.selectaById(Integer.valueOf(req.getParameter("id"))));
		req.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(req, resp);
	}

	private static void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		service.delectById(Integer.valueOf(id));
		resp.sendRedirect("show?service=show");
	}

}
