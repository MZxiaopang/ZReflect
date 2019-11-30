package com.zhiyou.uitl2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 修饰类，用来表示这个类是一个切面
public class AopUtil2 {

	@Pointcut("execution(* com.zhiyou.service..*.dd*(..))")

	public void sss() {// 配置这个方法为切点
	}

//	@Before("sss()") // 配置前置增强，引用上面的切入点
//	public void save2() {
//		System.out.println("开启事物");
//	}
//
//	@After("sss()") // 配置最终增强，引用上面的切入点
//	public void after2() {
//		System.out.println("释放资源");
//	}
//
//	@AfterReturning("sss()") //// 配置普通增强，引用上面的切入点
//	public void returningAfter2() {
//		System.out.println("提交事物");
//	}
//
//	@AfterThrowing("sss()") // 配置异常增强，引用上面的切入点
//	public void throwingAfter2() {
//		System.out.println("回滚事物");
//	}

	// 环绕增强必须返回Object固定要求
	// ProceedingJoinPoint底层Spring自动把要增加事物的类穿过来
	@Around("sss()")
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
