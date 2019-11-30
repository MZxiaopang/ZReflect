package com.zhiyou.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) // 让Spring容器运行在JUnit外面
@ContextConfiguration("classpath:spring.xml")
public class UserController {

	private UserService userService;

	public UserController() {

	}

	@Autowired
	ApplicationContext app;

	@Test
	public void method() {
		System.out.println(app.getBean("userController"));

	}

	@Override
	public String toString() {
		return "UserController [userService=" + userService + ", app=" + app + "]";
	}

	public UserService getUserService() {
		return userService;
	}
	// userService

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
