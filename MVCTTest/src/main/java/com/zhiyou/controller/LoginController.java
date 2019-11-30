package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService service;

	@RequestMapping("/login")
	public ModelAndView Login(String name, String password, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView view = new ModelAndView();
		boolean b = service.selectByNameBoolean(req, name, password);
		if (b) {
			view.setViewName("manager");
		} else {
			view.setViewName("redirect:returnLogin");
		}

		return view;
	}

	@RequestMapping("returnLogin")
	public void Login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
}
