package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Salgrade;
import com.zhiyou.service.SalgradeService;

@Controller
public class SalgradeController {
	@Autowired
	SalgradeService service;

	@RequestMapping("/salgradeShow")
	public ModelAndView SalgradeShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<Salgrade> list = service.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("salgradeShow");
		return modelAndView;
	}

	@RequestMapping("/salgradeAddShow")
	public ModelAndView SalgradeAddShow(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("salgradeAddShow");
		return modelAndView;
	}

	@RequestMapping("/salgradeAdd")
	public ModelAndView SalgradeAdd(Salgrade Salgrade, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.add(Salgrade);
		modelAndView.setViewName("forward:salgradeShow");
		return modelAndView;
	}

	@RequestMapping("/salgradeUpdateShow")
	public ModelAndView SalgradeUpdateShow(int id, HttpServletRequest req, HttpServletResponse res) {
		System.out.println(id);
		ModelAndView modelAndView = new ModelAndView();
		Salgrade Salgrade = service.selectById(id);
		modelAndView.addObject("list", Salgrade);
		modelAndView.setViewName("salgradeUpdateShow");
		return modelAndView;
	}

	@RequestMapping("/salgradeUpdate")
	public ModelAndView SalgradeUpdate(Salgrade Salgrade, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.update(Salgrade);
		modelAndView.setViewName("forward:salgradeShow");
		return modelAndView;
	}

	@RequestMapping("/salgradeDelete")
	public ModelAndView SalgradeDelete(int id, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		service.delete(id);
		modelAndView.setViewName("forward:salgradeShow");
		return modelAndView;
	}
}
