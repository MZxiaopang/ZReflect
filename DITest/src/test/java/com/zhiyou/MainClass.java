package com.zhiyou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 让Spring容器运行在JUnit外面
@ContextConfiguration("classpath:spring3.xml")
public class MainClass {
	@Autowired

	ApplicationContext app;

	@Test
	public void method() {
		System.out.println(app.getBean("a3"));
	}

}
