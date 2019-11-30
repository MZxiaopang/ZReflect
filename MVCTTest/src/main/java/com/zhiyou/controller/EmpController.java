package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Emp;
import com.zhiyou.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService service;

	@RequestMapping("/empShow")
	public ModelAndView EmpShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<Emp> list = service.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("empShow");
		return modelAndView;
	}

	@RequestMapping("/empAddShow")
	public ModelAndView EmpAddShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("empAddShow");
		return modelAndView;
	}

	@RequestMapping("/empAdd")
	public ModelAndView EmpAdd(Emp Emp, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.add(Emp);
		modelAndView.setViewName("forward:empShow");
		return modelAndView;
	}

	@RequestMapping("/empUpdateShow")
	public ModelAndView EmpUpdateShow(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		Emp Emp = service.selectById(id);
		modelAndView.addObject("list", Emp);
		modelAndView.setViewName("empUpdateShow");
		return modelAndView;
	}

	@RequestMapping("/empUpdate1")
	public ModelAndView EmpUpdate(Emp Emp, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.update(Emp);
		modelAndView.setViewName("forward:empShow");
		return modelAndView;
	}

	@RequestMapping("/empDelete")
	public ModelAndView EmpDelete(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.delete(id);
		modelAndView.setViewName("forward:empShow");
		return modelAndView;
	}
}
