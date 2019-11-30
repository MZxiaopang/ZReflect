package com.zhiyou;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 把这个类交给spring IOC容器管理
//@Scope("是否单例")  用来配置对象作用域
public class A {

	// @Autowired(required = false)
	// @Qualifier("b2adsa")
	// @Resource(name="b2adsaa")
	@Autowired(required = false)
	private B b;
	@Autowired(required = false)
	private C c;
	private String name;
	private int age;
	private List<String> lists;
	private Set<String> sets;
	private Map<String, String> maps;

	@PostConstruct // 使用注解指定对象创建的时候调用这个方法
	public void init() {
		System.out.println("对象被初始化");
	}

	public String getName() {
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

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	@PreDestroy // 使用注解指定对象销毁的时候调用这个方法
	public void exit() {
		System.out.println("对象被销毁");
	}

	@Override
	public String toString() {
		return "A [b=" + b + ", c=" + c + ", name=" + name + ", age=" + age + ", lists=" + lists + ", sets=" + sets
				+ ", maps=" + maps + "]";
	}

	/*
	 * public B getB() { return b; }
	 * 
	 * public void setB(B b) { this.b = b; }
	 */

	public A(B b, String name, int age, List<String> lists, Set<String> sets, Map<String, String> maps) {
		super();
		this.b = b;
		this.name = name;
		this.age = age;
		this.lists = lists;
		this.sets = sets;
		this.maps = maps;
	}

	public A() {
		super();
	}

}
