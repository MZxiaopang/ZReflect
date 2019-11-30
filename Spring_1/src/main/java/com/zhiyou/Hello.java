package com.zhiyou;

public class Hello {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hello() {
		System.out.println("私有化构造");
	}

	public void Hello1() {
		System.out.println("你好spring，我是:" + name);
	}

	public void SayHello() {
		System.out.println("你好Spring,我是" + name);
	}

	public void init() {
		System.out.println("初始化了hello类");
	}

	public void exit() {
		System.out.println("销毁了hello类对象");
	}
}
