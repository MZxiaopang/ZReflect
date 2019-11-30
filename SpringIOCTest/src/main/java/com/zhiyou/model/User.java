package com.zhiyou.model;

import org.springframework.beans.factory.annotation.Autowired;

//@Repository
public class User {

	@Autowired
	private Person p;
	private Integer id;
	private String password;
	private String name;
	private Integer age;

	public User() {
		super();
	}

	public User(Person p) {
		super();
		this.p = p;
	}

	public User(Person p, Integer id, String password, String name, Integer age) {
		super();
		this.p = p;
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", p=" + p + "]";
	}

}
