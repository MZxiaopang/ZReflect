package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 想让我们自己写的类变成一个用于接收客户端请求的类。需要实现controller接口,实现handleRequest方法
//

@Controller // 表示这个类交给ioc容器
@RequestMapping("/user") // 此类下所有的requestMapping 路径前面都会加上/user的路径
public class HelloController2 {

	@RequestMapping("/hello2") // url映射路径
	public void method(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("hello springMVC2");
		res.getWriter().write("hello spring mvc 2");
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST) // url映射路径
	public void method2(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("hello springMVC2");
		res.getWriter().write("hello spring mvc 3");
	}

}
