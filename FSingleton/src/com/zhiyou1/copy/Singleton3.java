package com.zhiyou1.copy;

public class Singleton3 {
//////////////////懒汉式1////////////////

	// 优点：在开始的时候不进行对象的创建，而是在需要的使用对象的时候
	// 在进行对象的创建 对内存来说比较优化

	// 缺点：线程不安全 当多线程并发的时候，可能会有多个线程同时进入到if判断中
	// 2:创建静态变量，但是先不进行对象的创建
	public static Singleton3 s = null;

	// 1：私有化构造方法，让外部无法直接通过构造器获取对象。

	private Singleton3() {
		System.out.println("创建了对象");
	}

	public static Singleton3 getSingleton3() {
		// 初次访问s是null 就进入if创建对象。如果不为null则不创建
		if (s == null) {
			s = new Singleton3();
		}
		return s;// 返回s
	}

}
