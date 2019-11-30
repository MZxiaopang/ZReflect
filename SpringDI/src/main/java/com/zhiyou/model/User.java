package com.zhiyou.model;

public class User {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void Say() {
		System.out.println("我的名字是：" + name);
	}

}
