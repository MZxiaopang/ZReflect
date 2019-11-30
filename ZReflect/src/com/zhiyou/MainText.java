package com.zhiyou;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainText {

	public static void main(String[] args) throws Exception {
		Class<Dog> c = Dog.class;
		Constructor<?>[] constructors = c.getConstructors();
		Dog o = null;
		for (Constructor<?> constructor : constructors) {
			if (constructor.getParameterCount() != 0) {
				o = (Dog) constructor.newInstance("小兵", 2, "绿");
			}

			System.out.println(o);
		}
		System.out.println("***************************************************");
		Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			if (constructor.getParameterCount() == 0) {
				o = (Dog) constructor.newInstance();
			}
		}
		System.out.println("***************************************************");
		Constructor<Dog> constructor = c.getConstructor();
		Dog cat = constructor.newInstance();
		System.out.println("***************************************************");
		Constructor<Dog> declaredConstructor = c.getDeclaredConstructor(String.class, int.class, String.class);
		declaredConstructor.setAccessible(true);
		Dog dog = declaredConstructor.newInstance("阿黄", 2, "15");
		System.out.println(dog);
		System.out.println("***************************************************");
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			method.setAccessible(true);
			System.out.println(method.getName());
		}
		System.out.println("***************************************************");
		Method[] declaredMethods = c.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
		System.out.println("***************************************************");
		Method method = c.getMethod("eat");
		method.invoke(cat);

		System.out.println("***************************************************");

		Method declaredMethod = c.getDeclaredMethod("eat2", String.class);
		declaredMethod.invoke(dog, "奥特曼！");
		System.out.println("***************************************************");

	}
}
