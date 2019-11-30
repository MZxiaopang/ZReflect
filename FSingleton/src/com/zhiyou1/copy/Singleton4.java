package com.zhiyou1.copy;

public class Singleton4 {
//////////////////懒汉式2////////////////

	// 优点：在开始的时候不进行对象的创建，而是在需要的使用对象的时候
	// 在进行对象的创建 对内存来说比较优化，加入synchronized后线程变得安全

	// 缺点：多线程完全失效，永远只有一个线程能执行这个方法，效率低下。

	// synchronized:线程锁，被起修饰的代码块，同时只能进入一个线程
	// 2:创建静态变量，但是先不进行对象的创建
	public static Singleton4 s = null;

	// 1：私有化构造方法，让外部无法直接通过构造器获取对象。

	private Singleton4() {
		System.out.println("创建了对象");
	}

	public static synchronized Singleton4 getSingleton4() {
		// 初次访问s是null 就进入if创建对象。如果不为null则不创建
		if (s == null) {
			s = new Singleton4();
		}
		return s;// 返回s
	}

}
