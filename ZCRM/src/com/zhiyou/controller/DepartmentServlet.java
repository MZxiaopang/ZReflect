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

import com.zhiyou.model.Department;
import com.zhiyou.model.User;
import com.zhiyou.service.DepartmentService;
import com.zhiyou.service.impl.DepartmentServiceImpl;
import com.zhiyou.util.SessionKey;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DepartmentService service = new DepartmentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("DepartmentGuanLi")) {
			show(request, response);
		}
		if (string.equals("DepartmentGuanLiFind")) {
			NameShow(request, response);
		}
		if (string.equals("selectDepartment")) {
			selectDepartment(request, response);
		}
		if (string.equals("DepartmentAdd")) {
			add(request, response);
		}
		if (string.equals("DepartmentUpdate")) {
			update(request, response);
		}
		if (string.equals("DepartmentAlter")) {
			try {
				alter(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("DepartmentDelete")) {
			delete(request, response);
		}
		if (string.equals("DepartmentXinXi")) {
			DepartmentXinXi(request, response);
		}

	}

	private void selectDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("department");
		System.out.println(string);
		boolean b = service.selectBy_Name(string);
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
		List<Department> list = service.selectByName(find);
		request.setAttribute("pageshow", "show1");
		request.setAttribute("count", list.size());
		request.setAttribute("list", list);
		request.setAttribute("nameshow", "nameshow");
		request.getRequestDispatcher("/WEB-INF/jsp/BuMenGuanLi.jsp").forward(request, response);
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
		String department_name = request.getParameter("department_name");
		String remark = request.getParameter("remark");

		if (id == null) {
			Department department = new Department(department_name, remark, Creater, format.parse(Create_Time));
			service.add(department);
		} else {
			Department department = new Department(Integer.valueOf(id), department_name, remark,
					Integer.valueOf(Old_Creater), format.parse(Old_Create_Time), Updater, format.parse(Create_Time));
			service.update(department);
		}
		request.getRequestDispatcher("DepartmentServlet?service=DepartmentGuanLi").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer integer = Integer.valueOf(request.getParameter("id"));
		Department department = service.selectById(integer);
		request.setAttribute("department", department);
		request.getRequestDispatcher("/WEB-INF/jsp/BuMenTianJia.jsp").forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/BuMenTianJia.jsp").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == null || request.getParameter("page") == "" ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		request.getRequestDispatcher("/WEB-INF/jsp/BuMenGuanLi.jsp").forward(request, response);

	}

	private void DepartmentXinXi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		Department id = service.selectById(user.getDepartment_id());
		request.setAttribute("list", id);
		request.getRequestDispatcher("/WEB-INF/jsp/BuMenXinXi.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("id");
		service.delete(Integer.valueOf(string));
		request.getRequestDispatcher("DepartmentServlet?service=DepartmentGuanLi").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
