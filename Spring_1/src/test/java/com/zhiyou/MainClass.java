package com.zhiyou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 让Spring容器运行在JUnit外面
@ContextConfiguration("classpath:spring.xml")
public class MainClass {

	@Test
	public void method() {
		// 1：加载Spring.xml配置文件,获得一个Resource对象
//		ClassPathResource resource = new ClassPathResource("spring.xml");
		// 2：读取配置文件信息，创建Spring 容器对象
//		BeanFactory beans = new XmlBeanFactory(resource);
		// 3：根据id从容器中拿出对象 <!-- 在soring2.5版本的时候name是可以重复的 如果根据id或name去取值，碰到重复的name会报错-->
//		Hello bean = (Hello) beans.getBean("h");
//		bean.SayHello();
//		bean.Hello1();

		// 单纯使用类型去获取bean 如果同类型的bean存在2个以上，取值的时候会无法返回
//		Hello bean2 = beans.getBean(Hello.class);
//		bean2.SayHello();

//		Hello bean3 = beans.getBean("hello", Hello.class);
//		bean3.SayHello();
	}

	@Autowired // 通过注解获得容器
	ApplicationContext beans;

	@Test
	public void method2() {
		Hello bean = (Hello) beans.getBean("hello");
//		Hello bean1 = (Hello) beans.getBean("factory2");
//		Hello bean2 = (Hello) beans.getBean("factory2");
		bean.SayHello();
//		bean.SayHello();
	}

//	public void method3() {
//		Hello bean = (Hello) beans.getBean("h");
//		bean.SayHello();
////		bean.SayHello();
//	}

}
