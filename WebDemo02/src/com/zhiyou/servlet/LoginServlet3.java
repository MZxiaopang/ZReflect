package com.zhiyou.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet3 extends HttpServlet {

	public LoginServlet3() {
		System.out.println("LoginServlet3");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		Enumeration<String> names = config.getInitParameterNames();

//		Iterator<String> iterator = names.asIterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获得xml中获得servlet方法
		System.out.println(req.getServletContext().getInitParameter("sex"));
		// ***由于网页默认编码不是utf-8所以 我们在获取参数前告诉请求以什么编码格式传递过来
		req.setCharacterEncoding("UTF-8");
		// ***根据表单中 input的 name的值来获得用户提交的信息，在servlet中获得的所有参数都是字符串
		String string = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(string);
		// 获取input 里面的name值,当不知道页面里面name属性值的时候，或页面input过多的时候使用此方法
		Enumeration<String> names = req.getParameterNames();
		Iterator<String> iterator = names.asIterator();
		System.out.println("*****************************************");
		while (iterator.hasNext()) {
			System.out.println(req.getParameter(iterator.next()));
		}
		System.out.println("*****************************************");

		// 获得前端页面input的name 以及对应输入框中用户输入的值
		Map<String, String[]> map = req.getParameterMap();
		Iterator<Entry<String, String[]>> i = map.entrySet().iterator();
		while (i.hasNext()) {
			System.out.println(i.next().getKey());

		}
		while (i.hasNext()) {
			System.out.println(i.next().getValue()[0]);
		}
		// 单纯接收复选框的值,其中传入参数为 复选框的name的值
		String[] values = req.getParameterValues("");

		// 获得指定的请求信息
		System.out.println(req.getHeader("Accept"));
		// 获得当前请求的资源路径
		System.out.println(req.getRequestURI());
		// 获得当前的URL
		System.out.println(req.getRequestURL());
		// 获得当前客户端地址
		System.out.println(req.getRemoteAddr());
		// 获得当前客户端ip
		System.out.println(req.getRemoteHost());
		// 获得当前客户端端口
		System.out.println(req.getRemotePort());
///////////////////////////////////////////////////////////////////////////////////
		// 设置响应内容的编码
		resp.setCharacterEncoding("UTF-8");
		// 响应的内容格式MIME 类型
		resp.setContentType("text/html");
		// 上面的两句可以合并成一句
		resp.setContentType("text/html;charset=UTF-8");

		// 字节流和字符流不能同时存在

		// 字节输出流 用于文件 下载
//		ServletOutputStream stream = resp.getOutputStream();
//		stream.write("<p>唐诗三百首</p>".getBytes());
//		stream.close();

		// 字符流返回响应, 注意：字符流不能同时存在
//		PrintWriter writer = resp.getWriter();
//		writer.write("<p><h1>唐诗三百首</h1></p>");
//		writer.close();
		if (string.equals("admin") && password.equals("123456")) {
			// 请求转发，使用请求request 进行页面跳转
			// getRequestDispatcher 的参数为需要跳转到的页面路径
			// forward（）参数为 request 及 response 对象
			req.getRequestDispatcher("show.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("login.html").forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
//		System.out.println("post提交");
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("get   post  都走这里");
//	}
}
