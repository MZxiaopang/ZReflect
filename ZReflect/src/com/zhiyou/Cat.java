package com.zhiyou;

public class Cat {

	private String name;
	private int age;
	private String color;
	public String c;
	static {
		System.out.println("Cat类被加载了");
	}
	{
		System.out.println("创建了一个Cat对象");
	}

	public void eat() {
		System.out.println("猫吃鱼，狗吃肉，奥特曼打小怪兽");
	}

	private void eat2(String name) {
		System.out.println("猫吃鱼，狗吃肉，奥特曼打小怪兽" + name);
	}

	public String getName() {
		System.out.println("Cat的getname方法被调用");

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

	public Cat(String name, int age, String color, String c) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.c = c;
	}

	public Cat() {

	}
}
