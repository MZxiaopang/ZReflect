package com.zhiyou;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class MainClass3 {

	public static void main(String[] args) throws Exception {
		System.out.println("请输入需要权限定名");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		// 通过第三种方式在程序运行期间 获得一个Class 对象
		Class<?> c = Class.forName(name);
		Constructor<?> constructor = c.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object ooObject = constructor.newInstance();
		System.out.println(ooObject);
	}
}
