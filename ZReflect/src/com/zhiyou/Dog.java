package com.zhiyou;

public class Dog {

	private String name;
	private int age;
	private String color;

	public Dog() {
		System.out.println("狗无参");
	}

	public Dog(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		System.out.println("狗有参");
	}

	public void eat() {
		System.out.println("狗狗吃肉！");
	}

	public void eat2(String name) {
		System.out.println("狗狗吃" + name + "！");
	}

	static {
		System.out.println("Dog类被加载了");
	}
	{
		System.out.println("创建了一个Dog对象");
	}

	public String getName() {
		System.out.println("Dog的getname方法被调用");

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
		return "Dog [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

}
