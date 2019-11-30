package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
	@NonNull
	private Integer DEPTION;
	@NonNull
	private String DNAME;
	@NonNull
	private String LOC;

}
