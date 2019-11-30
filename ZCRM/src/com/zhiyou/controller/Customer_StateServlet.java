package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer_State;
import com.zhiyou.service.Customer_StateService;
import com.zhiyou.service.impl.Customer_StateServiceImpl;

/**
 * Servlet implementation class Customer_StateServlet
 */
public class Customer_StateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Customer_StateService service = new Customer_StateServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("Customer_StateGuanLi")) {
			show(request, response);
		}
		if (string.equals("Customer_StateDelete")) {
			delete(request, response);
		}
		if (string.equals("Customer_StateUpdate")) {
			update(request, response);
		}
		if (string.equals("Customer_StateAdd")) {
			add(request, response);
		}
		if (string.equals("Customer_StateAlter")) {

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
		String id = request.getParameter("customer_state_id") == "" ? null : request.getParameter("customer_state_id");
		System.out.println(id);
		String customer_state_name = request.getParameter("customer_state_name") == "" ? null
				: request.getParameter("customer_state_name");
		String customer_state_desc = request.getParameter("customer_state_desc") == "" ? null
				: request.getParameter("customer_state_desc");
		String status = request.getParameter("status") == "" ? "1" : request.getParameter("status");
		String remark = request.getParameter("remark") == "" ? null : request.getParameter("remark");
		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" ? "1" : request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" ? "1" : request.getParameter("updater");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (id == null) {
			Customer_State care = new Customer_State(customer_state_name, customer_state_desc, Integer.valueOf(status),
					remark, format.parse(create_time), Integer.valueOf(creater), format.parse(update_time),
					Integer.valueOf(updater));
			service.add(care);
		} else {
			System.out.println(111);

			Customer_State care = new Customer_State(Integer.valueOf(id), customer_state_name, customer_state_desc,
					Integer.valueOf(status), remark, format.parse(create_time), Integer.valueOf(creater),
					format.parse(update_time), Integer.valueOf(updater));
			System.out.println(222);
			service.update(care);
		}
		request.getRequestDispatcher("Customer_StateGuanLi?service=Customer_StateGuanLi").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_StateTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		Customer_State Customer_State = service.selectByCustomer_State_Id(Integer.valueOf(id));
		request.setAttribute("Customer_State", Customer_State);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_StateTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("Customer_StateGuanLi?service=Customer_StateGuanLi").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Customer_State> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_StateGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
