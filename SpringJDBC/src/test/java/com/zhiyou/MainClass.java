package com.zhiyou;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring2.xml")
public class MainClass {

	@Resource
	UserService Service;

	@Test
	public void add() {
		User user = new User();
		user.setId(5);
		user.setAge(88);
		user.setName("通用11");
		user.setPassword("aaa");
		Service.add(user);

	}

	@Test
	public void update() {
		User user = new User();
		user.setId(1);
		user.setAge(88);
		user.setName("哦哦哦");
		user.setPassword("aaa");
		Service.update(user);

	}

	@Test
	public void delete() {

		Service.delete(3);
	}

	@Test
	public void selectAll() {
		List<User> list = Service.selectByName("2");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Autowired
	UserDao dao;

	@Test
	public void method3() {
		dao.selectOne(2);
	}

}
