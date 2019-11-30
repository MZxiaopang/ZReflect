package com.zhiyou;

import java.lang.reflect.Proxy;

import org.junit.Test;

// JDK 动态代理
public class MainClass1 {

	@Test
	public void method() {
		MyProxy proxy = new MyProxy(new XHBook());
		BookMan milk = (BookMan) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), // 参数为代理类的类加载器
				new Class[] { BookMan.class }, // 参数为被代理类实现的所有接口
				proxy);// 参数为我们写的代理对象
		milk.sellingBook();
		milk.sellingPoster();
	}
}
