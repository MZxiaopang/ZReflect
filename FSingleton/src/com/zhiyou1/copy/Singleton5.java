package com.zhiyou1.copy;

public class Singleton5 {
//////////////////懒汉式2////////////////

	// 优点：在开始的时候不进行对象的创建，而是在需要的使用对象的时候
	// 在进行对象的创建 对内存来说比较优化，加入synchronized后线程变得安全,使用双重if判断
	// 让线程只有第一次执行的时候才有可能进入到线程锁的代码块排队,来实现改善效率

	// 缺点：多线程完全失效，永远只有一个线程能执行这个方法，效率低下。

	// synchronized:线程锁，被起修饰的代码块，同时只能进入一个线程
	// 2:创建静态变量，但是先不进行对象的创建
	public static Singleton5 s = null;

	// 1：私有化构造方法，让外部无法直接通过构造器获取对象。

	private Singleton5() {
		System.out.println("创建了对象");
	}

	public static Singleton5 getSingleton5() {
		// 初次访问s是null 就进入if创建对象。如果不为null则不创建
		if (s == null) {// 只有线程初次访问才会进入这个if，
			// 然后进入下面线程进行排队，当线程再次执行则不会再进入下面排队了
			synchronized (Singleton5.class) {// 当第一个线程进入，拿锁
				if (s == null) {// 当多线程第一次执行的时候
					// ，有可能同时有多个线程进入到上面的if中，如果不加这层if判断，就会造成所有第一次进入线程的多会创建对象
					s = new Singleton5();
				}
			}
		}
		return s;// 返回s
	}

}
