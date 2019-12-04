package com.zhiyou.model;

public class User {
	private Integer a_id;
	private String password;
	private String a_name;
	private Integer age;

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [a_id=" + a_id + ", password=" + password + ", a_name=" + a_name + ", age=" + age + "]";
	}

}
