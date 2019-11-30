package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@NonNull
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String password;
	@NonNull
	private Integer age;

}
