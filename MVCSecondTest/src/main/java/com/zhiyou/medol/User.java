package com.zhiyou.medol;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private Integer id;
	private String password;
	private String name;
	private Integer age;

	public User(Integer id, String password, String name, Integer age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
	}

	public User(String password, String name, Integer age) {
		super();
		this.password = password;
		this.name = name;
		this.age = age;
	}

}
