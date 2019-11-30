package com.zhiyou.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.medol.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	// 展示数据
	@RequestMapping("/show")
	public String show(HttpServletRequest req, HttpServletResponse res) {
		List<User> list = service.selectAll();
		req.setAttribute("list", list);
		return "show";
	}

	// 添加数据界面
	@RequestMapping("/addshow")
	public String addshow(HttpServletRequest req, HttpServletResponse res) {

		return "index";
	}

	// 添加操作
	@RequestMapping("/addmethod")
	public String addmethod(User user, HttpServletRequest req, HttpServletResponse res) {
		service.add(user);
		return "show";
	}

	// 修改数据界面
	@RequestMapping("/updateshow")
	public String updateshow(int id, HttpServletRequest req, HttpServletResponse res) {
		List<User> list = service.selectById(id);
		req.setAttribute("list", list.get(0));
		return "forward:login1";

	}

	// 修改操作
	@RequestMapping("/updatemethod")
	public String updatemethod(User user, HttpServletRequest req, HttpServletResponse res) {
		service.update(user);
		return "show";
	}

	// 删除操作
	@RequestMapping("/delete")
	public String delete(User user, HttpServletRequest req, HttpServletResponse res) {
		service.delete(user.getId());
		return "show";
	}

	@RequestMapping("/login1")
	public String delete1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		return "login.jsp";
//		req.getRequestDispatcher("login.jsp").forward(req, res);
	}

}
