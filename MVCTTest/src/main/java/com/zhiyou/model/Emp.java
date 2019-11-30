package com.zhiyou.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

	@NonNull
	private Integer EMPNO;
	@NonNull
	private String ENAME;
	@NonNull
	private String JOB;
	@NonNull
	private Integer MGR;
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date HIREDATE;
	@NonNull
	private Integer SAL;
	@NonNull
	private Integer COMM;
	@NonNull
	private Integer DEPTNO;

}
