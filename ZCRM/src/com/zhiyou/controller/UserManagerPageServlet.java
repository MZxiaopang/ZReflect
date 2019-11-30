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
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserSerivceImpl;
import com.zhiyou.util.SessionKey;

/**
 * Servlet implementation class ManagerPageServlet
 */
public class UserManagerPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserSerivceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("UserGuanLi")) {
			show(request, response);
		}
		if (string.equals("UserGuanLiFind")) {
			NameShow(request, response);
		}
		if (string.equals("YuanGongXinXi")) {
			YuanGongShow(request, response);
		}
		if (string.equals("selectUser")) {
			selectUser(request, response);
		}
		if (string.equals("selectUserMobile")) {
			selectUserMobile(request, response);
		}
		if (string.equals("selectUserId_num")) {
			selectUserId_num(request, response);
		}
		if (string.equals("selectUserCard_num")) {
			selectUserCard_num(request, response);
		}
		if (string.equals("Useradd")) {
			add(request, response);
		}
		if (string.equals("Useralter")) {
			try {
				alter(request, response);
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("Userdelete")) {
			delete(request, response);
		}
		if (string.equals("Userupdate")) {
			update(request, response);
		}
	}

	private void selectUserCard_num(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String card_num1 = request.getParameter("card_num1");
		boolean b = service.selectByCard_num(Long.valueOf(card_num1));
		response.getWriter().write(b + "");
	}

	private void selectUserId_num(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id_num1 = request.getParameter("id_num1");
		boolean b = service.selectById_num(Long.valueOf(id_num1));
		response.getWriter().write(b + "");
	}

	private void selectUserMobile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String mobile1 = request.getParameter("mobile1");
		boolean b = service.selectByMobile(Long.valueOf(mobile1));
		response.getWriter().write(b + "");
	}

	private void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username1 = request.getParameter("username1");
		boolean b = service.selectByUser_Name(username1);
		response.getWriter().write(b + "");
	}

	private void YuanGongShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		List<User> list = service.selectAll(user.getDepartment_id());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/YuanGongXinXi.jsp").forward(request, response);
	}

	private void NameShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String find = request.getParameter("find") == "" ? "^^^^" : request.getParameter("find");
		System.out.println(find);
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<User> list = service.selectByName(find, page);
		request.setAttribute("count", list.size());
		request.setAttribute("list", list);
		request.setAttribute("nameshow", "nameshow");
		request.getRequestDispatcher("/WEB-INF/jsp/UserGuanli.jsp").forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		User user = service.selectById(Integer.valueOf(id));
		request.setAttribute("user", user);
		List<Role> RoleList = service.selectRoleAll();
		request.setAttribute("RoleList", RoleList);
		List<Department> DepartmentList = service.selectDepatmentAll();
		request.setAttribute("DepartmentList", DepartmentList);
		request.setAttribute("a", "更新用户");
		request.getRequestDispatcher("/WEB-INF/jsp/UserAdd.jsp").forward(request, response);

	}

	private void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		User user1 = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		String id = request.getParameter("id") == "" ? null : request.getParameter("id");
		String username = request.getParameter("username") == "" ? null : request.getParameter("username");
		String password = request.getParameter("password") == "" ? null : request.getParameter("password");
		Integer bumen = Integer.valueOf(request.getParameter("bumen") == "" ? "1" : request.getParameter("bumen"));
		Integer juese = Integer.valueOf(request.getParameter("juese") == "" ? "1" : request.getParameter("juese"));
		Boolean sex = Boolean.valueOf(request.getParameter("sex") == "" ? "1" : request.getParameter("sex"));
		Boolean messager = Boolean.valueOf(request.getParameter("messager"));
		String shouji = request.getParameter("shouji") == "" ? null : request.getParameter("shouji");
		String dizhi = request.getParameter("dizhi") == "" ? null : request.getParameter("dizhi");
		Integer age = Integer.valueOf(request.getParameter("age") == "" ? "1" : request.getParameter("bumen"));
		String dianhua = request.getParameter("dianhua") == "" ? null : request.getParameter("dianhua");
		String shenfenzhenghao = request.getParameter("shenfenzhenghao") == "" ? null
				: request.getParameter("shenfenzhenghao");
		String youxiang = request.getParameter("youxiang") == "" ? null : request.getParameter("youxiang");
		Integer qq = Integer.valueOf(request.getParameter("qq") == "" ? "1" : request.getParameter("qq"));
		String aihao = request.getParameter("aihao") == "" ? null : request.getParameter("aihao");
		Integer xueli = Integer.valueOf(request.getParameter("xueli") == "" ? "1" : request.getParameter("xueli"));
		String gongzhikahao = request.getParameter("gongzhikahao") == "" ? null : request.getParameter("gongzhikahao");
		String minzu = request.getParameter("minzu") == "" ? null : request.getParameter("minzu");
		Integer hunyin = Integer.valueOf(request.getParameter("hunyin") == "" ? "1" : request.getParameter("hunyin"));
		String beizhu = request.getParameter("beizhu") == "" ? null : request.getParameter("beizhu");
		String creater = request.getParameter("creater");
		String date = String.valueOf(new Date());
		String create_time = request.getParameter("create_time");
		String create_time1 = format.format(new Date());
		if (id == null) {
			User user = new User(format.parse(create_time1), user1.getUser_id(), messager, bumen, juese, username, sex,
					shouji, age, dizhi, password, dianhua, shenfenzhenghao, youxiang, aihao, xueli, gongzhikahao, minzu,
					hunyin, beizhu, qq);
			service.add(user);

		} else {
			User user = new User(Integer.valueOf(creater), format.parse(create_time), user1.getUser_id(), messager,
					Integer.valueOf(id), bumen, juese, username, sex, shouji, age, dizhi, password, dianhua,
					shenfenzhenghao, youxiang, aihao, xueli, gongzhikahao, minzu, hunyin, beizhu, qq);
			service.update(user);

		}
		request.getRequestDispatcher("ManagerPageServlet?service=UserGuanLi").forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Role> RoleList = service.selectRoleAll();
		request.setAttribute("RoleList", RoleList);
		List<Department> DepartmentList = service.selectDepatmentAll();
		request.setAttribute("DepartmentList", DepartmentList);
		request.setAttribute("a", "添加用户");
		request.getRequestDispatcher("/WEB-INF/jsp/UserAdd.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("id");
		service.delete(Integer.valueOf(user_id));
		request.getRequestDispatcher("ManagerPageServlet?service=UserGuanLi").forward(request, response);

	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = service.selectCount();

		int page = request.getParameter("page") == null || request.getParameter("page") == "" ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		request.getRequestDispatcher("/WEB-INF/jsp/UserGuanli.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
