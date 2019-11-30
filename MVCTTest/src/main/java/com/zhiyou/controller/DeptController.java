package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Dept;
import com.zhiyou.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService service;

	@RequestMapping("/deptShow")
	public ModelAndView DeptShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<Dept> list = service.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("deptShow");
		return modelAndView;
	}

	@RequestMapping("/deptAddShow")
	public ModelAndView DeptAddShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("deptAddShow");
		return modelAndView;
	}

	@RequestMapping("/deptAdd")
	public ModelAndView DeptAdd(Dept Dept, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.add(Dept);
		modelAndView.setViewName("forward:deptShow");
		return modelAndView;
	}

	@RequestMapping("/deptUpdateShow")
	public ModelAndView DeptUpdateShow(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		Dept Dept = service.selectById(id);
		modelAndView.addObject("list", Dept);
		modelAndView.setViewName("deptUpdateShow");
		return modelAndView;
	}

	@RequestMapping("/deptUpdate")
	public ModelAndView DeptUpdate(Dept Dept, HttpServletRequest req, HttpServletResponse res) {
		System.out.println(Dept);
		ModelAndView modelAndView = new ModelAndView();
		service.update(Dept);
		modelAndView.setViewName("forward:deptShow");
		return modelAndView;
	}

	@RequestMapping("/deptDelete")
	public ModelAndView DeptDelete(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.delete(id);
		modelAndView.setViewName("forward:deptShow");
		return modelAndView;
	}
}
