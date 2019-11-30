package com.zhiyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;

	public void method(String name) {
		User user = service.selectByName(name);
		System.out.println(user);
	}
}
