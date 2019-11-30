package com.zhiyou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) // 让Spring容器运行在JUnit外面
@ContextConfiguration("classpath:spring2.xml")
public class MainClass {

	@Autowired
	UserService service;

	@Test
	public void method() {
		service.ddUser();
		// service.deleteUser();
	}
}
