package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer_Link;
import com.zhiyou.service.Customer_LinkService;
import com.zhiyou.service.impl.Customer_LinkServiceImpl;

public class Customer_LinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Customer_LinkService service = new Customer_LinkServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("Customer_LinkGuanLi")) {
			show(request, response);
		}
		if (string.equals("Customer_LinkDelete")) {
			delete(request, response);
		}
		if (string.equals("Customer_LinkUpdate")) {
			update(request, response);
		}
		if (string.equals("Customer_LinkAdd")) {
			add(request, response);
		}
		if (string.equals("Customer_LinkAlter")) {

			try {
				alter(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void alter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String link_id = request.getParameter("link_id") == "" ? null : request.getParameter("link_id");

		String customer_id = request.getParameter("customer_id") == "" || request.getParameter("customer_id") == null
				? "1"
				: request.getParameter("customer_id");

		String link_name = request.getParameter("link_name") == "" || request.getParameter("link_name") == null ? "1"
				: request.getParameter("link_name");

		String link_is_male = request.getParameter("link_is_male") == "" || request.getParameter("link_is_male") == null
				? "1"
				: request.getParameter("link_is_male");
		String link_position = request.getParameter("link_position") == ""
				|| request.getParameter("link_position") == null ? "1" : request.getParameter("link_position");
		String link_mobile = request.getParameter("link_mobile") == "" || request.getParameter("link_mobile") == null
				? "1"
				: request.getParameter("link_mobile");
		String link_age = request.getParameter("link_age") == "" || request.getParameter("link_age") == null ? "1"
				: request.getParameter("link_age");
		String link_relation = request.getParameter("link_relation") == ""
				|| request.getParameter("link_relation") == null ? "1" : request.getParameter("link_relation");
		String status = request.getParameter("status") == "" || request.getParameter("status") == null ? "1"
				: request.getParameter("status");
		String remark = request.getParameter("remark") == "" || request.getParameter("remark") == null ? "1"
				: request.getParameter("remark");
		String next_time = request.getParameter("next_time") == "" ? null : request.getParameter("next_time");

		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" || request.getParameter("creater") == null ? "1"
				: request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" || request.getParameter("updater") == null ? "1"
				: request.getParameter("updater");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		if (link_id == null) {
			Customer_Link customer = new Customer_Link(Integer.valueOf(customer_id), link_name, link_is_male,
					link_position, link_mobile, Integer.valueOf(link_age), Integer.valueOf(link_relation),
					Integer.valueOf(status), remark, format.parse(next_time), format.parse(create_time),
					Integer.valueOf(creater), format.parse(update_time), Integer.valueOf(updater));
			service.add(customer);
		} else {

			Customer_Link customer = new Customer_Link(Integer.valueOf(link_id), Integer.valueOf(customer_id),
					link_name, link_is_male, link_position, link_mobile, Integer.valueOf(link_age),
					Integer.valueOf(link_relation), Integer.valueOf(status), remark, format.parse(next_time),
					format.parse(create_time), Integer.valueOf(creater), format.parse(update_time),
					Integer.valueOf(updater));

			service.update(customer);

		}
		request.getRequestDispatcher("Customer_LinkGuanLi?service=Customer_LinkGuanLi").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_LinkTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		Customer_Link customer = service.selectByCustomer_Link_Id(Integer.valueOf(id));
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_LinkTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("Customer_LinkGuanLi?service=Customer_LinkGuanLi").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("count", count);
		List<Customer_Link> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_LinkGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
