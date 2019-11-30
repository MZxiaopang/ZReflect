package com.zhiyou.uitl;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopUtil {

	public void save() {
		System.out.println("在方法执行前进行增强操作");
	}

	public void after() {
		System.out.println("在方法执行后进行增强操作");
	}

	public void throwingAfter() {
		System.out.println("在方法执行过程出现异常执行的代码");
	}

	public void returningAfter() {
		System.out.println("普通后置增强");
	}

	// 环绕增强必须返回Object固定要求
	// ProceedingJoinPoint底层Spring自动把要增加事物的类穿过来
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("开启事物----------前置增强");
		Object obj = null;
		try {
			obj = pjp.proceed();// 正常调用业务方法
			System.out.println("正常执行，提交事物");
		} catch (Throwable e) {
			System.out.println("出现错误，回滚事物");
		} finally {
			System.out.println("关闭资源");
		}
		return obj;
	}
}
