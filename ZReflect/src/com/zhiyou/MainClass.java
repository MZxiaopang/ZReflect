package com.zhiyou;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainClass {

	public static void main(String[] args) throws Exception {

		// 获得字节码对象
		Class<Cat> cl = Cat.class;
		// 获得cat类的所有属性（不包括私有）
		Field[] fields = cl.getFields();
		// 获得cat 类中所有的属性 包括私有的属性
		Field[] declaredFields = cl.getDeclaredFields();

		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
		System.out.println("***********************************************");
		// 使用getMethods()获得一个class 的所有非私有方法
		Method[] methods = cl.getMethods();
		// 使用 getDeclaredFields（）可以获得类本身所有的方法，但获取不到父类继承的
		Method[] declaredFields2 = cl.getDeclaredMethods();
		for (Method method : declaredFields2) {
			System.out.println(method.getName());
		}

		System.out.println("***********************************************");
		// 通过getConstructors() 获得一个雷的构造方法（不包括私有）
		Constructor<?>[] constructors = cl.getConstructors();
		// 通过getDeclaredConstructors() 获得一个雷的所有构造方法
		Constructor<?>[] declaredConstructors = cl.getDeclaredConstructors();

		Cat o = null;

		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			if (constructor.getParameterCount() == 0) {
				o = (Cat) constructor.newInstance();
			}
		}

//		Method[] declaredFields3 = cl.getDeclaredMethods();
//		for (Method method : declaredFields3) {
//			System.out.println(method.getName());
//			System.out.println(method.getParameterCount());
//			if (method.getName().equals("setName")) {
//				System.out.println(method.invoke(o, "旺财"));
//			}
//			if (method.getName().equals("setColor")) {
//				System.out.println(method.invoke(o, "黑色"));
//
//			}
//			if (method.getName().equals("setAge")) {
//				System.out.println(method.invoke(o, 2));
//			}
//		}
		System.out.println("***********************************************");

		Field[] declaredFields1 = cl.getDeclaredFields();

		for (Field field : declaredFields1) {
			// 通过setAccessible（true）来暴力公开方法或者属性的权限，使其权限公开
			field.setAccessible(true);
			// 获得属性名
			System.out.println(field.getName());
			if (field.getName().equals("name")) {
				field.set(o, "小黑");
			}
			if (field.getName().equals("age")) {
				field.set(o, 3);
			}
			if (field.getName().equals("color")) {
				field.set(o, "白色");
			}
		}

		System.out.println(o);

		Method declaredMethod = cl.getDeclaredMethod("eat");
		declaredMethod.setAccessible(true);
		declaredMethod.invoke(o);
	}

}
