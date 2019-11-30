package com.zhiyou;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//公共代理类
public class MyProxy implements InvocationHandler {

	private Object obj;// 需要被代理的对象

	public MyProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.out.println("厂家吐血大甩卖，全部5折起");
		Object object = method.invoke(obj, args);// 通过需要被代理的对象调用方法
		System.out.println("购买产品成功，送您优惠券");
		return object;
	}

}
