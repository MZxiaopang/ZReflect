package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer_Care;
import com.zhiyou.service.Customer_CareService;
import com.zhiyou.service.impl.Customer_CareServiceImpl;

public class Customer_CareServlet extends HttpServlet {

	private static Customer_CareService service = new Customer_CareServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("Customer_CareGuanLi")) {
			show(request, response);
		}
		if (string.equals("Customer_CareDelete")) {
			delete(request, response);
		}
		if (string.equals("Customer_CareUpdate")) {
			update(request, response);
		}
		if (string.equals("Customer_CareAdd")) {
			add(request, response);
		}
		if (string.equals("Customer_CareAlter")) {

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
		String id = request.getParameter("customer_care_id") == "" ? null : request.getParameter("customer_care_id");
		String customer_id = request.getParameter("customer_id") == "" ? "1" : request.getParameter("customer_id");
		String care_subject = request.getParameter("care_subject") == "" ? null : request.getParameter("care_subject");
		String care_type = request.getParameter("care_type") == "" ? null : request.getParameter("care_type");
		String status = request.getParameter("status") == "" ? "1" : request.getParameter("status");
		String remark = request.getParameter("remark") == "" ? null : request.getParameter("remark");
		String next_time = request.getParameter("next_time") == "" ? null : request.getParameter("next_time");
		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" ? "1" : request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" ? "1" : request.getParameter("updater");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (id == null) {
			Customer_Care care = new Customer_Care(Integer.valueOf(customer_id), care_subject, care_type,
					Integer.valueOf(status), remark, format.parse(next_time), format.parse(create_time),
					Integer.valueOf(creater), format.parse(update_time), Integer.valueOf(updater));
			service.add(care);
		} else {
			Customer_Care care = new Customer_Care(Integer.valueOf(id), Integer.valueOf(customer_id), care_subject,
					care_type, Integer.valueOf(status), remark, format.parse(next_time), format.parse(create_time),
					Integer.valueOf(creater), format.parse(update_time), Integer.valueOf(updater));
			service.update(care);
		}
		request.getRequestDispatcher("Customer_CareGuanLi?service=Customer_CareGuanLi").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/KeHuGuanHuaiTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Customer_Care customer_Care_id = service.selectByCustomer_Care_id(Integer.valueOf(id));
		request.setAttribute("customer_Care_id", customer_Care_id);
		request.getRequestDispatcher("/WEB-INF/jsp/KeHuGuanHuaiTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("Customer_CareGuanLi?service=Customer_CareGuanLi").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Customer_Care> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/KeHuGuanHuaiGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
