package com.zhiyou;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainClass2 {

	public static void main(String[] args) throws Exception {

		Class<?> class2 = Class.forName("com.zhiyou.Cat");

		Field[] fields3 = class2.getDeclaredFields();
		for (Field field : fields3) {
			System.out.println(field);
		}
		Constructor<?> constructor3 = class2.getConstructor();
		Object instance = constructor3.newInstance();
		Constructor<?> constructor4 = class2.getDeclaredConstructor();
		Object instance2 = constructor4.newInstance();
		Constructor<?> constructor5 = class2.getConstructor(String.class, int.class, String.class, String.class);
		Object instance3 = constructor5.newInstance("里", 2, "啊", "的");
		System.out.println(instance3);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Cat cat1 = new Cat();
		Class<? extends Cat> class1 = cat1.getClass();
		Constructor<? extends Cat> constructor2 = class1.getDeclaredConstructor();
		Method[] methods = class1.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Field[] fields2 = class1.getDeclaredFields();
		for (Field field : fields2) {
			System.out.println(field);
		}

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Cat cat4 = constructor2.newInstance();

		Field field2 = class1.getDeclaredField("name");
		field2.setAccessible(true);
		field2.set(cat4, "李四");
		System.out.println(cat4);

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Method method4 = class1.getDeclaredMethod("eat2", String.class);
		method4.setAccessible(true);
		method4.invoke(cat4, "嗷嗷嗷");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		// 获得类的class对象
		Class<Cat> c = Cat.class;
		// 获得公开的构造方法
		Constructor<?>[] constructors = c.getConstructors();
		// 获得所有的构造方法
		Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			System.out.println(constructor + "**************");
		}
		// 获得无参构造方法（公开的）
		// Constructor<Cat> constructor = c.getConstructor();
		// 获得私有的无参构造方法
		Constructor<Cat> declaredConstructor = c.getDeclaredConstructor();
		// 公开构造方法权限
		declaredConstructor.setAccessible(true);
		// 通过公开过权限的无参构造方法获得对象
		Cat cat = declaredConstructor.newInstance();
		System.out.println(cat);
		// 获得有参的构造方法 根据有参构造方法的参数 传入对应的.class 类型即可
		Constructor<Cat> declaredConstructor1 = c.getDeclaredConstructor(String.class, int.class, String.class,
				String.class);
		// 公开构造方法权限
		declaredConstructor1.setAccessible(true);
		Cat cat2 = declaredConstructor1.newInstance("小黑", 2, "白色", "A");
		System.out.println(cat2);
		System.out.println("***********************11*****************************");
		// 获得所有类中的公开的方法（包含父类）
		// Method[] methods = c.getMethods();

		Method method2 = c.getMethod("setColor", String.class);
		method2.invoke(cat, "绿色");
		Method method3 = c.getMethod("getColor");
		System.out.println(method3.invoke(cat));

		System.out.println("**********************11******************************");
		// 获得所有类中的全部的方法（不包含父类）
		Method[] declaredMethods = c.getDeclaredMethods();
		// 获得类中指定的公开方法 传入参数为 方法名称 ，方法形参class类型（无参方法可以不写参数）
		Method method = c.getMethod("setName", String.class);
		// 调用方法 传入参数为 调用方法的对象 调用方法需要的参数（无参方法可以不写参数）
		method.invoke(cat, "小花");
		// 获得无参方法
		Method method1 = c.getMethod("getName");
		// 调用无参方法
		System.out.println(method1.invoke(cat));
		// 获得指定的方法 （包括公开）
		Method declaredMethod = c.getDeclaredMethod("eat2", String.class);
		// 公开方法权限
		declaredMethod.setAccessible(true);

		declaredMethod.invoke(cat2, "奥特曼");

		System.out.println("****************************************************");
		// 获得类中所有公开属性
		Field[] fields = c.getFields();
		// 获得类中所有的属性
		Field[] declaredFields = c.getDeclaredFields();
		// 获得类中指定公开属性
		Field field = c.getField("c");
		// 对属性赋值
		field.set(cat2, "哈哈哈");
		// 对属性取值
		System.out.println(field.get(cat2));

		// 获得类中指定私有属性
		Field declaredField = c.getDeclaredField("name");
		// 公开权限
		declaredField.setAccessible(true);
		// 对属性进行赋值
		declaredField.set(cat2, "哈士奇");
		// 取值
		System.out.println(declaredField.get(cat2));

		// 如果类中有公开的无参构造
		Cat cat3 = c.newInstance();

	}
}
