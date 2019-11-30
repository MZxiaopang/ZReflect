package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController3 {

	// 方式一：使用元生servlet api进行跳转
	@RequestMapping("/tiao1")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect("method");

	}

	// 方式二: 使用SpringMVC的ModelandView
	// 可以使用视图解析器，
	// 如果需要重定向 可以使用redirect
	// 如果需要请求转发 可以使用forward
	@RequestMapping("/tiao2")
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/method");
		return view;

	}
	// 方式三: 返回值直接为字符串。默认会走视图解析器 进行前后缀的添加，默认使用请求转发
	// 由于走了视图解析器所以可以
	// 如果需要重定向 可以使用redirect:
	// 如果需要请求转发 可以使用forward:
	//

	@RequestMapping("/tiao3")
	public String login3(HttpServletRequest request, HttpServletResponse response) throws IOException {

		return "redirect:method";

	}

	@RequestMapping("/method")
	public void method() {
		System.out.println("他跳进来了");
	}

}
