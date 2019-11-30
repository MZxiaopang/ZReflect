package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer_Source;
import com.zhiyou.service.Customer_SourceService;
import com.zhiyou.service.impl.Customer_SourceServiceImpl;

public class Customer_SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Customer_SourceService service = new Customer_SourceServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("Customer_SourceGuanLi")) {
			show(request, response);
		}
		if (string.equals("Customer_SourceDelete")) {
			delete(request, response);
		}
		if (string.equals("Customer_SourceUpdate")) {
			update(request, response);
		}
		if (string.equals("Customer_SourceAdd")) {
			add(request, response);
		}
		if (string.equals("Customer_SourceAlter")) {

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
		String id = request.getParameter("customer_source_id") == "" ? null
				: request.getParameter("customer_source_id");
		System.out.println(id);
		String customer_source_name = request.getParameter("customer_source_name") == "" ? null
				: request.getParameter("customer_source_name");
		String customer_source_desc = request.getParameter("customer_source_desc") == "" ? null
				: request.getParameter("customer_source_desc");
		String status = request.getParameter("status") == "" ? "1" : request.getParameter("status");
		String remark = request.getParameter("remark") == "" ? null : request.getParameter("remark");
		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" ? "1" : request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" ? "1" : request.getParameter("updater");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (id == null) {
			Customer_Source care = new Customer_Source(customer_source_name, customer_source_desc,
					Integer.valueOf(status), remark, format.parse(create_time), Integer.valueOf(creater),
					format.parse(update_time), Integer.valueOf(updater));
			service.add(care);
		} else {
			System.out.println(111);
			Customer_Source care = new Customer_Source(Integer.valueOf(id), customer_source_name, customer_source_desc,
					Integer.valueOf(status), remark, format.parse(create_time), Integer.valueOf(creater),
					format.parse(update_time), Integer.valueOf(updater));
			System.out.println(222);
			service.update(care);
		}
		request.getRequestDispatcher("Customer_SourceGuanLi?service=Customer_SourceGuanLi").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_SourceTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		Customer_Source Customer_Source = service.selectByCustomer_Source_Id(Integer.valueOf(id));
		request.setAttribute("Customer_Source", Customer_Source);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_SourceTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("Customer_SourceGuanLi?service=Customer_SourceGuanLi").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Customer_Source> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_SourceGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
