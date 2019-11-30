package com.zhiyou.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.RoleService;
import com.zhiyou.service.impl.RoleServiceImpl;
import com.zhiyou.util.SessionKey;

public class RoleManagePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RoleService service = new RoleServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);

		if (string.equals("RoleGuanLi")) {
			show(request, response);
		}
		if (string.equals("RoleGuanLiFind")) {
			NameShow(request, response);
		}
		if (string.equals("selectRole_Name")) {
			selectRole_Name(request, response);
		}
		if (string.equals("RoleAdd")) {
			add(request, response);
		}
		if (string.equals("RoleUpdate")) {
			update(request, response);
		}
		if (string.equals("RoleAlter")) {
			try {
				alter(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("RoleDelete")) {
			delete(request, response);
		}
		if (string.equals("JueSeXinXi")) {
			JueSeXinXi(request, response);
		}

	}

	private void selectRole_Name(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("name1");
		System.out.println(string);
		boolean b = service.selectByName(string);
		System.out.println(b);
		response.getWriter().write(b + "");
	}

	private void NameShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String find = request.getParameter("find") == "" ? "^^^^" : request.getParameter("find");
		System.out.println(find);
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Role> list = service.selectByName(find, (page - 1) * 5);
		request.setAttribute("count", list.size());
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("nameshow", "nameshow");
		request.getRequestDispatcher("/WEB-INF/jsp/JueSeGuanLi.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("id");
		service.delete(Integer.valueOf(string));
		request.getRequestDispatcher("RoleDelete?service=RoleGuanLi").forward(request, response);
	}

	private void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer Creater = user.getUser_id();
		String Create_Time = format.format(new Date());
		String Old_Create_Time = request.getParameter("create_time");
		String Old_Creater = request.getParameter("creater");
		Integer Updater = user.getUser_id();

		String id = request.getParameter("id") == "" ? null : request.getParameter("id");
		String jueSeMingCheng = request.getParameter("jueSeMingCheng");
		String jueSeMiaoShu = request.getParameter("jueSeMiaoShu");

		if (id == null) {
			Role role = new Role(jueSeMingCheng, jueSeMiaoShu, Creater, format.parse(Create_Time));
			service.add(role);
		} else {
			Role role = new Role(Integer.valueOf(id), jueSeMingCheng, jueSeMiaoShu, format.parse(Old_Create_Time),
					Integer.valueOf(Old_Creater), Updater, format.parse(Create_Time));
			System.out.println(role);
			service.update(role);
		}
		request.getRequestDispatcher("RoleManagePageServlet?service=RoleGuanLi").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer integer = Integer.valueOf(request.getParameter("id"));
		Role role = service.selectById(integer);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/WEB-INF/jsp/JueSeTianJia.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/JueSeTianJia.jsp").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int count = service.selectCount();

		int page = request.getParameter("page") == null || request.getParameter("page") == "" ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		request.getRequestDispatcher("/WEB-INF/jsp/JueSeGuanLi.jsp").forward(request, response);
	}

	private void JueSeXinXi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Role> list = service.selectAll(0, 100);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/JueSeXinXi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
