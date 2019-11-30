package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	// 在对象被销毁时调用的方法
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁servlet");
	}

	// 构造方法
	public LoginServlet() {
		System.out.println("创建servlet");
	}

	// 获取当前servlet配置信息对象 的方法
	public ServletConfig getServletConfig() {

		return null;
	}

	// 返回servlet信息的方法
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	// 在servlet第一次被加载的时候调用
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化servlet");

	}

	// 处理请求与响应请求的方法
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("欢迎登陆");
	}

}
