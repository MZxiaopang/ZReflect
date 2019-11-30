package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer_Category;
import com.zhiyou.service.Customer_CategoryService;
import com.zhiyou.service.impl.Customer_CategoryServiceImpl;

public class Customer_CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Customer_CategoryService service = new Customer_CategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("Customer_CategoryGuanLi")) {
			show(request, response);
		}
		if (string.equals("Customer_CategoryDelete")) {
			delete(request, response);
		}
		if (string.equals("Customer_CategoryUpdate")) {
			update(request, response);
		}
		if (string.equals("Customer_CategoryAdd")) {
			add(request, response);
		}
		if (string.equals("Customer_CategoryAlter")) {

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
		String id = request.getParameter("Customer_Category_id") == "" ? null
				: request.getParameter("Customer_Category_id");
		String customer_category_name = request.getParameter("customer_category_name") == "" ? null
				: request.getParameter("customer_category_name");
		String customer_category_desc = request.getParameter("customer_category_desc") == "" ? null
				: request.getParameter("customer_category_desc");
		String status = request.getParameter("status") == "" ? "1" : request.getParameter("status");
		String remark = request.getParameter("remark") == "" ? null : request.getParameter("remark");
		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" ? "1" : request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" ? "1" : request.getParameter("updater");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (id == null) {
			Customer_Category care = new Customer_Category(customer_category_name, customer_category_desc,
					Integer.valueOf(status), remark, format.parse(create_time), Integer.valueOf(creater),
					format.parse(update_time), Integer.valueOf(updater));
			service.add(care);
		} else {
			Customer_Category care = new Customer_Category(Integer.valueOf(id), customer_category_name,
					customer_category_desc, Integer.valueOf(status), remark, format.parse(create_time),
					Integer.valueOf(creater), format.parse(update_time), Integer.valueOf(updater));
			service.update(care);
		}
		request.getRequestDispatcher("Customer_CategoryGuanLi?service=Customer_CategoryGuanLi").forward(request,
				response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_CategoryTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		Customer_Category Customer_Category = service.selectByCustomer_Category_Id(Integer.valueOf(id));
		request.setAttribute("Customer_Category", Customer_Category);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_CategoryTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("Customer_CategoryGuanLi?service=Customer_CategoryGuanLi").forward(request,
				response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Customer_Category> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_CategoryGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
