package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salgrade {

	@NonNull
	private Integer GRADE;
	@NonNull
	private Integer LOSAL;
	@NonNull
	private Integer HISAL;

}
