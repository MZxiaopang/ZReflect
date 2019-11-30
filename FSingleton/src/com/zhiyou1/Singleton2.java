package com.zhiyou1;

public class Singleton2 {
//////////////////饿汉式2////////////////
	// 优点: 写法简单，线程安全，因为被static修饰的成员在内存中永远只有一个，
	// 所以线程安全,静态内部类不会与静态成员同时被加载，而是在调用的时候才会被加载
	// 所以解决了之前，内存占用的问题

	// 缺点:无
	// 被static修饰的在内存中永远只有一个,线程安全

	public static String n = "张三";
	public static int a = 17;

	// 2：声明一个静态内部类
	private static class gsingleton2 {
		// 3: 在静态内部类中，声明静态变量，然后创建对象、
		private static Singleton2 s = new Singleton2();
	}
	// 1：私有化构造方法，让外部无法直接通过构造器获取对象。

	private Singleton2() {
		System.out.println("创建了对象");
	}

	// 4： 提供公开的静态方法，返回上面声明的自身对象
	public static Singleton2 getSingleton2() {
		return gsingleton2.s;
	}

}
