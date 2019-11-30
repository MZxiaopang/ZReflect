package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/userShow")
	public ModelAndView userShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<User> list = service.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("userShow");
		return modelAndView;
	}

	@RequestMapping("/userAddShow")
	public ModelAndView userAddShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("userAddShow");
		return modelAndView;
	}

	@RequestMapping("/userAdd")
	public ModelAndView userAdd(User user, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.add(user);
		modelAndView.setViewName("forward:userShow");
		return modelAndView;
	}

	@RequestMapping("/userUpdateShow")
	public ModelAndView userUpdateShow(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		User user = service.selectById(id);
		modelAndView.addObject("list", user);
		modelAndView.setViewName("userUpdateShow");
		return modelAndView;
	}

	@RequestMapping("/userUpdate")
	public ModelAndView userUpdate(User user, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.update(user);
		modelAndView.setViewName("forward:userShow");
		return modelAndView;
	}

	@RequestMapping("/userDelete")
	public ModelAndView userDelete(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.delete(id);
		modelAndView.setViewName("forward:userShow");
		return modelAndView;
	}

}
