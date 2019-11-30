package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.model.User;

//SpringMVC 接受参数的方式
@Controller
public class LoginController {

	// 方式一：使用元素servlet api进行接收
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("asdasdasd");
	}

	// 方式二：形参列表形式接收
	// 要求：形参名称需要与jsp页面name保持一致，要不然不知道需要接受那个input的参数（同名匹配原则）
	// 如果真的不想通过同名匹配的话可以使用@RequestParam("password") 注解，
	// 将指定input输入框中的值注入到其后面的形参中（注解中写的是input的name的名字）
	// 优点：对比起servletAPI 来讲，代码简化了很多，并且做到了自动的类型转换
	// 缺点：如果需要接受参数过多的情况下。形参列表会超级长。代码观赏性较差
	@RequestMapping(value = "/login2")
	public void login2(int id, @RequestParam("password") String ps, String name, int age, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(id);
		System.out.println(ps);
		System.out.println(name);
		System.out.println(age);

	}

	// 方式三：形参列表模型传参,将前端传过来的参数封装成对应的model类对象，然后注入到形参中
	//
	//
	@RequestMapping(value = "/login3")
	public void login3(User user, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(user);

	}

	// 方式四：地址栏传参，Restful风格
	// 之前访问后台：http://127..0.01:8080/SpringMVC/login?username=zhangsan
	// Restful访问后台：http://127.0.0.1:8080/SpringMVC/login/zhangsan
	@RequestMapping(value = "/login4/{idd}")
	public void login4(@PathVariable("idd") int idd, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(idd);
	}
}
