package com.zhiyou1;

public class Singleton1 {
//////////////////饿汉式1////////////////
	// 优点：写法简单，线程安全，因为被static修饰的成员在内存中永远只有一个，所以线程安全
	// 缺点，当调用类中其他静态成员的时候，会自动创建对象，哪怕你根本就不使用这个对象的资源
	// 被static修饰的在内存中永远只有一个,线程安全

	// 2：声明一个静态成员变量,在本类中直接创建对象
	public static Singleton1 s = new Singleton1();
	public static String n = "哈哈";
	// 1：私有化构造方法，让外部无法直接通过构造器获取对象。

	private Singleton1() {
		System.out.println("创建了对象");
	}

	// 3： 提供公开的静态方法，返回上面声明的自身对象
	public static Singleton1 getSingleton1() {
		return s;
	}

	public static void main(String[] args) {
		System.out.println(getSingleton1());
		System.out.println(getSingleton1());
		System.out.println(getSingleton1());
		System.out.println(getSingleton1());
		System.out.println(getSingleton1());
	}
}
