package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("userShow")
	public String show(HttpServletRequest req, HttpServletResponse res) {
		List<User> list = service.selectByEvery(new User(0, null, null, 0));
		int count = list.size();

		String page = req.getParameter("page") == "" || req.getParameter("page") == null ? "1"
				: req.getParameter("page");
		req.setAttribute("list", service.selectAll((Integer.valueOf(page) - 1) * 5, 5));

		req.setAttribute("count", count);
		req.setAttribute("page", page);

		return "userShow";
	}

	@RequestMapping("userAddShow")
	public String addshow(User user, HttpServletRequest req, HttpServletResponse res) {
		return "userAdd";
	}

	@RequestMapping("userAdd")
	public String add(User user, HttpServletRequest req, HttpServletResponse res) {
		service.add(user);
		return "redirect:userShow";
	}

	@RequestMapping("userDelete")
	public String delete(int id, HttpServletRequest req, HttpServletResponse res) {
		service.delete(id);
		return "redirect:userShow";
	}

	@RequestMapping("userUpdate")
	public String update(User user, HttpServletRequest req, HttpServletResponse res) {
		service.update(user);
		return "forward:userShow";
	}

	@RequestMapping("userUpdeteShow")
	public String selectByOtherInt(int id, HttpServletRequest req, HttpServletResponse res) {
		List<User> list = service.selectByOtherInt(id);
		req.setAttribute("list", list.get(0));
		return "userUpdate";
	}

	@RequestMapping("search")
	public String searchSelectBy(User user, String select, String chose, HttpServletRequest req,
			HttpServletResponse res) {
		List<User> list = null;
		if (Integer.valueOf(select) == 1) {
			list = service.selectByEvery(new User(0, chose, null, 0));
		}
		if (Integer.valueOf(select) == 2) {

			list = service.selectByEvery(new User(0, null, null, Integer.valueOf(chose)));
		}

		req.setAttribute("list", list);
		return "userShow";
	}

}
