package com.zhiyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.service.Customer_Link_RecordService;
import com.zhiyou.service.impl.Customer_Link_RecordServiceImpl;

public class Customer_Link_RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer_Link_RecordService service = new Customer_Link_RecordServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("Customer_Link_RecordGuanLi")) {
			show(request, response);
		}
		if (string.equals("Customer_Link_RecordDelete")) {
			delete(request, response);
		}
		if (string.equals("Customer_Link_RecordUpdate")) {
			update(request, response);
		}
		if (string.equals("Customer_Link_RecordAdd")) {
			add(request, response);
		}
		if (string.equals("Customer_Link_RecordAlter")) {

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
		String id = request.getParameter("record_id") == "" ? null : request.getParameter("record_id");
		String customer_id = request.getParameter("customer_id") == "" ? null : request.getParameter("customer_id");
		String link_type = request.getParameter("link_type") == "" ? null : request.getParameter("link_type");
		String link_subject = request.getParameter("link_subject") == "" ? null : request.getParameter("link_subject");
		String link_nexttime = request.getParameter("link_nexttime") == "" ? null
				: request.getParameter("link_nexttime");
		String status = request.getParameter("status") == "" ? "1" : request.getParameter("status");
		String remark = request.getParameter("remark") == "" ? null : request.getParameter("remark");
		String next_time = request.getParameter("next_time") == "" ? null : request.getParameter("next_time");
		String create_time = request.getParameter("create_time") == "" ? null : request.getParameter("create_time");
		String creater = request.getParameter("creater") == "" ? "1" : request.getParameter("creater");
		String update_time = request.getParameter("update_time") == "" ? null : request.getParameter("update_time");
		String updater = request.getParameter("updater") == "" ? "1" : request.getParameter("updater");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (id == null) {
			Customer_Link_Record care = new Customer_Link_Record(Integer.valueOf(customer_id), link_type, link_subject,
					format.parse(link_nexttime), Integer.valueOf(status), remark, format.parse(next_time),
					format.parse(create_time), Integer.valueOf(creater), format.parse(update_time),
					Integer.valueOf(updater));
			service.add(care);
		} else {
			Customer_Link_Record care = new Customer_Link_Record(Integer.valueOf(id), Integer.valueOf(customer_id),
					link_type, link_subject, format.parse(link_nexttime), Integer.valueOf(status), remark,
					format.parse(next_time), format.parse(create_time), Integer.valueOf(creater),
					format.parse(update_time), Integer.valueOf(updater));
			service.update(care);
		}
		request.getRequestDispatcher("Customer_Link_RecordGuanLi?service=Customer_Link_RecordGuanLi").forward(request,
				response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_Link_RecordTianJia.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		Customer_Link_Record Customer_Link_Record = service.selectByCustomer_Link_Record_Id(Integer.valueOf(id));
		System.out.println(Customer_Link_Record);
		request.setAttribute("Customer_Link_Record", Customer_Link_Record);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_Link_RecordTianJia.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id") == "" ? "1" : request.getParameter("id");
		service.delete(Integer.valueOf(id));
		request.getRequestDispatcher("Customer_Link_RecordGuanLi?service=Customer_Link_RecordGuanLi").forward(request,
				response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == "" || request.getParameter("page") == null ? 1
				: Integer.valueOf(request.getParameter("page"));
		List<Customer_Link_Record> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/Customer_Link_RecordGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
