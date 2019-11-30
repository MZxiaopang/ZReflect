package com.zhiyou.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.User;

//SpringMVC 返回参数的方式

@Controller
public class LoginController2 {

	// 方式一：使用元生servlet api进行返回
	@RequestMapping("/set1")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "世界那么美，你想去看看");

		return "c.jsp";
	}

	// 方式二：使用ModelandView 传值，
	// model.addObject("哈哈"); 默认配为key对应数据类型首字母小写,同类型会覆盖
	// model.addObject("msg", "世界真美");根据key取值，若key相同会覆盖。
	// model.addAllObjects(map);传递map对象，根据map的key取值
	@RequestMapping("/set2")
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		User u = new User(34, "句话", "卡号是", 3);
		model.addObject("快递放假");
		model.addObject(u);
		model.setViewName("c.jsp");
		model.addObject("msg", "世界真美");
		Map<String, String> map = new HashMap<String, String>();
		map.put("s1", "value1");
		map.put("s2", "value2");
		map.put("s3", "value3");
		model.addAllObjects(map);

		return model;
	}

	// 方式三：直接返回User对象
	// 由于没有返回视图，Spirngmvc不知道用该展示那个视图，所以就会把当前访问的路径名当成视图 再次进行访问
	// 这样会造成无限循环访问当前路径 这个时候可以配置视图解析器来解决这个问题
	// 如果加上@RespinseBody的话 会直接把user对象转换成json返回给前端
	// （适用于AJAX）加上@ResponseBody会返回到当前页面不会进行页面跳转
	@ResponseBody
	@RequestMapping("/set3")
	public User login3(HttpServletRequest request, HttpServletResponse response) {
		User u = new User(34, "句话", "卡号是", 3);

		return u;
	}

}
