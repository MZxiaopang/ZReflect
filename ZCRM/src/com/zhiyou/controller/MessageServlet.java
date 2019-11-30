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

import com.zhiyou.model.Message;
import com.zhiyou.model.User;
import com.zhiyou.service.MessageService;
import com.zhiyou.service.impl.MessageServiceImpl;
import com.zhiyou.util.SessionKey;

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MessageService service = new MessageServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("MessageGuanLi")) {
			show(request, response);
		}
		if (string.equals("MessageCollection")) {
			CollectionShow(request, response);
		}
		if (string.equals("MessageWrite")) {
			WriteShow(request, response);
		}
		if (string.equals("selectUser")) {
			selectUser(request, response);
		}
		if (string.equals("MessageSave")) {
			try {
				alter(request, response);
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("MessageUpdate")) {
			update(request, response);
		}
		if (string.equals("NewUpdate")) {
			try {
				NewUpdate(request, response);
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("NewSend")) {
			NewSend(request, response);
		}
		if (string.equals("MessageAlter")) {
			try {
				alter(request, response);
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("MessagesendDelete")) {
			senddelete(request, response);
		}
		if (string.equals("MessageholdDelete")) {
			holddelete(request, response);
		}
		if (string.equals("MessagereceiveDelete")) {
			receivedelete(request, response);
		}
		if (string.equals("MessageRe_BinDelete")) {
			Re_Bindelete(request, response);
		}
		if (string.equals("MessageSe_BinDelete")) {
			Se_Bindelete(request, response);
		}
		if (string.equals("MessageReallyDelete")) {
			ReallyDelete(request, response);
		}
		if (string.equals("MessageSendBox")) {
			SendShow(request, response);
		}
		if (string.equals("MessageHoldBox")) {
			HoldShow(request, response);
		}
		if (string.equals("MessageBinBox")) {
			BinShow(request, response);
		}

	}

	private void NewSend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		service.AgainSend(Integer.valueOf(id));
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiHoldBoxShow.jsp").forward(request, response);
	}

	private void Se_Bindelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		if (user.getUser_id().equals(Integer.valueOf(id))) {

		}
		service.Se_Bindelete(Integer.valueOf(id));
		request.getRequestDispatcher("MessageServlet?service=MessageBinBox").forward(request, response);
	}

	private void NewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ParseException, ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String id = request.getParameter("id") == "" ? null : request.getParameter("id");
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		String send_status = request.getParameter("send_status");
		String send_delete = request.getParameter("send_delete");
		String receive_delete = request.getParameter("receive_delete");
		String receive_status = request.getParameter("receive_status");
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		String save_time = format.format(new Date());
		String send_time = request.getParameter("send_time");
		String send_update_time = request.getParameter("send_update_time");
		String receive_update_time = request.getParameter("receive_update_time");

		Message message = new Message(Integer.valueOf(id), subject, content, user.getUser_id(),
				Integer.valueOf(send_delete), Integer.valueOf(send_status), format.parse(save_time),
				format.parse(send_time), format.parse(send_update_time), Integer.valueOf(receiver),
				Integer.valueOf(receive_delete), Integer.valueOf(receive_status), format.parse(receive_update_time));

		service.update(message);
		request.getRequestDispatcher("MessageServlet?service=MessageHoldBox").forward(request, response);

	}

	private void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String string = request.getParameter("username");
		boolean b = service.selectByAllUser(Integer.valueOf(string));
		response.getWriter().write(b + "");

	}

	private void holddelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		service.senddelete(Integer.valueOf(id));
		request.getRequestDispatcher("MessageServlet?service=MessageHoldBox").forward(request, response);
	}

	private void Re_Bindelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		if (user.getUser_id().equals(Integer.valueOf(id))) {

		}
		service.Re_Bindelete(Integer.valueOf(id));
		request.getRequestDispatcher("MessageServlet?service=MessageBinBox").forward(request, response);
	}

	private void receivedelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		service.receivedelete(Integer.valueOf(id));
		request.getRequestDispatcher("MessageServlet?service=MessageHoldBox").forward(request, response);
	}

	private void ReallyDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		service.ReallyDelete(Integer.valueOf(id));
		request.getRequestDispatcher("MessageServlet?service=MessageBinBox").forward(request, response);
	}

	private void BinShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.valueOf(request.getParameter("page") == "" || request.getParameter("page") == null ? "1"
				: request.getParameter("page"));
		request.setAttribute("page", page);
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		List<Message> list = service.selectsend_delete0(user);
		request.setAttribute("list", list);
		List<Message> list1 = service.selectreceive_delete0(user);
		request.setAttribute("count", list1.size() + list.size());
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiBinBoxShow.jsp").forward(request, response);
	}

	private void HoldShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.valueOf(request.getParameter("page") == "" || request.getParameter("page") == null ? "1"
				: request.getParameter("page"));
		request.setAttribute("page", page);
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		List<Message> list = service.selectSend_status0(user);
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiHoldBoxShow.jsp").forward(request, response);
	}

	private void SendShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = Integer.valueOf(request.getParameter("page") == "" || request.getParameter("page") == null ? "1"
				: request.getParameter("page"));
		request.setAttribute("page", page);
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		List<Message> list = service.selectSend_status2(user);
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiSendBoxShow.jsp").forward(request, response);
	}

	private void senddelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		service.senddelete(Integer.valueOf(id));
		request.getRequestDispatcher("MessageServlet?service=MessageSendBox").forward(request, response);
	}

	private void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String text = request.getParameter("text");
		String id = request.getParameter("id") == "" ? null : request.getParameter("id");
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		String send_status = request.getParameter("send_status");
		String send_delete = request.getParameter("send_delete");
		String receive_delete = request.getParameter("receive_delete");
		String receive_status = request.getParameter("receive_status");
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		String save_time = request.getParameter("save_time") == null ? "1997-9-5 00:00:00"
				: request.getParameter("save_time");
		String send_time = format.format(new Date());
		String send_update_time = request.getParameter("send_update_time") == null ? "1997-9-5 00:00:00"
				: request.getParameter("send_update_time");
		;
		String receive_update_time = request.getParameter("receive_update_time") == null ? "1997-9-5 00:00:00"
				: request.getParameter("receive_update_time");
		;
		if (text.equals("text")) {
			send_status = "0";
			save_time = format.format(new Date());
		}
		if (id == null) {
			Message message = new Message(subject, content, user.getUser_id(), Integer.valueOf(send_delete),
					Integer.valueOf(send_status), format.parse(save_time), format.parse(send_time),
					format.parse(send_update_time), Integer.valueOf(receiver), Integer.valueOf(receive_delete),
					Integer.valueOf(receive_status), format.parse(receive_update_time));
			service.add(message);
		} else {
			Message message = new Message(Integer.valueOf(id), subject, content, Integer.valueOf(user.getUser_id()),
					Integer.valueOf(send_status), Integer.valueOf(receiver), Integer.valueOf(receive_status),
					Integer.valueOf(receive_delete));
			service.update(message);
		}
		request.getRequestDispatcher("MessageCollection?service=MessageSendBox").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Message message = service.selectById(Integer.valueOf(id));
		request.setAttribute("list", message);
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiUpdate.jsp").forward(request, response);
	}

	private void WriteShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("bianji", "发送邮件");
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiWrite.jsp").forward(request, response);
	}

	private void CollectionShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute(SessionKey.USER_LOGIN);

		int page = Integer.valueOf(request.getParameter("page") == "" || request.getParameter("page") == null ? "1"
				: request.getParameter("page"));

		List<Message> list = service.selectAll((page - 1) * 5, 5, user);
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/XinXiCollect.jsp").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = Integer.valueOf(request.getParameter("page") == "" || request.getParameter("page") == null ? "1"
				: request.getParameter("page"));
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		List<Message> list = service.selectAll((page - 1) * 5, 5);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/jsp/XinXiGuanLi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
