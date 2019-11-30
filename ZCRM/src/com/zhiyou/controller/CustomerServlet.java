package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer;
import com.zhiyou.service.CustomerService;
import com.zhiyou.service.impl.CustomerServiceImpl;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService service = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("CustomerGuanLi")) {
			show(request, response);
		}
		if (string.equals("selectPhone")) {
			selectPhone(request, response);
		}
		if (string.equals("CustomerDelete")) {
			delete(request, response);
		}
		if (string.equals("CustomerUpdate")) {
			update(request, response);
		}
		if (string.equals("CustomerAdd")) {
			add(request, response);
		}
		if (string.equals("CustomerAlter")) {

			try {
				alter(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void selectPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("Phone1");
		System.out.println(string);
		boolean b = service.selectByPhone(string);
		System.out.println(b);
		response.getWriter().write(b + "");
	}

	private void alter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String customer_id = request.getParameter("customer_id") == "" ? null : request.getParameter("customer_id");

		String customer_state_id = request.getParameter("customer_state_id") == ""
				|| request.getParameter("customer_state_id") == null ? "1" : request.getParameter("customer_state_id");
		String customer_source_id = request.getParameter("customer_source_id") == ""
				|| request.getParameter("customer_state_id") == null ? "1" : request.getParameter("customer_state_id");
		String user_id = request.getParameter("user_id") == "" || request.getParameter("user_id") == null ? "1"
				: request.getParameter("user_id");
		String customer_category_id = request.getParameter("customer_category_id") == ""
				|| request.getParameter("customer_category_id") == null ? "1"
						: request.getParameter("customer_category_id");
		String customer_name = request.getParameter("customer_name") == ""
				|| request.getParameter("customer_name") == null ? "1" : request.getParameter("customer_name");
		String customer_is_male = request.getParameter("customer_is_male") == ""
				|| request.getParameter("customer_is_male") == null ? "1" : request.getParameter("customer_is_male");
		String customer_mobile = request.getParameter("customer_mobile") == ""
				|| request.getParameter("customer_mobile") == null ? "1" : request.getParameter("customer_mobile");
		String customer_qq = request.getParameter("customer_qq") == "" || request.getParameter("customer_qq") == null
				? "1"
				: request.getParameter("customer_qq");
		String customer_address = request.getParameter("customer_address") == ""
				|| request.getParameter("customer_address") == null ? "1" : request.getParameter("customer_address");
		String customer_email = request.getParameter("customer_email") == ""
				|| request.getParameter("customer_email") == null ? "1" : request.getParameter("customer_email");
		String customer_remark = request.getParameter("customer_remark") == ""
				|| request.getParameter("customer_remark") == null ? "1" : request.getParameter("customer_remark");
		String customer_position = request.getParameter("customer_position") == ""
				|| request.getParameter("customer_position") == null ? "1" : request.getParameter("customer_position");
		String customer_blog = request.getParameter("customer_blog") == ""
				|| request.getParameter("customer_blog") == null ? "1" : request.getParameter("customer_blog");
		String customer_tel = request.getParameter("customer_tel") == "" || request.getParameter("customer_tel") == null
				? "1"
				: request.getParameter("customer_tel");
		String customer_birth = request.getParameter("customer_birth") == "" ? null
				: request.getParameter("customer_birth");
		String customer_company = request.getParameter("customer_company") == ""
				|| request.getParameter("customer_company") == null ? "1" : request.getParameter("customer_company");
		String status = request.getParameter("status") == "" || request.getParameter("status") == null ? "1"
				: request.getParameter("status");
		String remark = request.getParameter("remark") == "" || request.getParameter("remark") == null ? "1"
				: request.getParameter("remark");
		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" || request.getParameter("creater") == null ? "1"
				: request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" || request.getParameter("updater") == null ? "1"
				: request.getParameter("updater");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (customer_id == null) {
			Customer customer = new Customer(Integer.valueOf(customer_state_id), Integer.valueOf(customer_source_id),
					Integer.valueOf(user_id), Integer.valueOf(customer_category_id), customer_name,
					Boolean.valueOf(customer_is_male), customer_mobile, customer_qq, customer_address, customer_email,
					customer_remark, customer_position, customer_blog, customer_tel, format.parse(customer_birth),
					customer_company, Integer.valueOf(status), remark, format.parse(create_time),
					Integer.valueOf(creater), format.parse(update_time), Integer.valueOf(updater));
			service.add(customer);
		} else {
			Customer customer = new Customer(Integer.valueOf(customer_id), Integer.valueOf(customer_state_id),
					Integer.valueOf(customer_source_id), Integer.valueOf(user_id),
					Integer.valueOf(customer_category_id), customer_name, Boolean.valueOf(customer_is_male),
					customer_mobile, customer_qq, customer_address, customer_email, customer_remark, customer_position,
					customer_blog, customer_tel, format.parse(customer_birth), customer_company,
					Integer.valueOf(status), remark, format.parse(create_time), Integer.valueOf(creater),
					format.parse(update_time), Integer.valueOf(updater));
			service.update(customer);
		}
		request.getRequestDispatcher("CustomerGuanLi?service=CustomerGuanLi").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/KeHuXinXiTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		Customer customer = service.selectByCustomer_id(Integer.valueOf(id));
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/jsp/KeHuXinXiTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("CustomerGuanLi?service=CustomerGuanLi").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("count", count);
		List<Customer> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/KeHuXinXiGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
