package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.User;
import com.zhiyou.service.NoticeService;
import com.zhiyou.service.impl.NoticeServiceImpl;
import com.zhiyou.util.SessionKey;

public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NoticeService service = new NoticeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String string = req.getParameter("service");
		System.out.println(string);

		if (string.equals("NoticeGuanLi")) {
			show(req, resp);
		}
		if (string.equals("NoticeGuanLiFind")) {
			NameShow(req, resp);
		}
		if (string.equals("NoticeAdd")) {
			add(req, resp);
		}
		if (string.equals("NoticeDelete")) {
			delete(req, resp);
		}
		if (string.equals("NoticeAlter")) {
			try {
				alter(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (string.equals("NoticeUpdate")) {
			update(req, resp);
		}
		if (string.equals("GongGaoTongZhi")) {
			GongGaoTongZhi(req, resp);
		}
	}

	private void NameShow(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String find = request.getParameter("find") == "" ? "^^^^" : request.getParameter("find");
		System.out.println(find);
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Notice> list = service.selectByName(find);
		request.setAttribute("count", list.size());
		request.setAttribute("list", list);
		request.setAttribute("nameshow", "nameshow");
		request.getRequestDispatcher("/WEB-INF/jsp/GongGaoGuanLi.jsp").forward(request, resp);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Notice notice = service.selectByNotice_id(Integer.valueOf(id));
		request.setAttribute("notice", notice);
		List<Department> list = service.selectDepartmentAll();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/GongGaoTianJia.jsp").forward(request, response);
	}

	private void alter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer Creater = user.getUser_id();
		String Create_Time = format1.format(new Date());
		String Old_Create_Time = request.getParameter("create_time");
		String Old_Creater = request.getParameter("creater");
		Integer Updater = user.getUser_id();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String id = request.getParameter("id") == "" ? null : request.getParameter("id");
		String Old_pub_time = request.getParameter("pub_time");
		String expire_time = request.getParameter("expire_time") == "" ? "2019-11-7"
				: request.getParameter("expire_time");
		String subject = request.getParameter("subject");
		String tongzhifanwei = request.getParameter("tongzhifanwei");
		String text = request.getParameter("text");

		if (id == null) {

			Notice notice = new Notice(Integer.valueOf(tongzhifanwei), subject, text, format1.parse(Create_Time),
					format.parse(expire_time), Creater, format1.parse(Create_Time));
			service.add(notice);
		} else {
			Notice notice = new Notice(Integer.valueOf(id), Integer.valueOf(tongzhifanwei), subject, text,
					format1.parse(Old_pub_time), format.parse(expire_time), Integer.valueOf(Old_Creater),
					format1.parse(Old_Create_Time), Updater, format1.parse(Create_Time));
			service.update(notice);
		}
		request.getRequestDispatcher("NoticeServlet?service=NoticeGuanLi").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("id");
		service.delete(Integer.valueOf(string));
		request.getRequestDispatcher("NoticeServlet?service=NoticeGuanLi").forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Department> list = service.selectDepartmentAll();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/GongGaoTianJia.jsp").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		int count = service.selectCount();
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		List<Notice> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/jsp/GongGaoGuanLi.jsp").forward(request, response);
	}

	private void GongGaoTongZhi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		List<Notice> list = service.selectAll((page - 1) * 5, 5, user);
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		request.getRequestDispatcher("/WEB-INF/jsp/GongGaoTongZhi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
