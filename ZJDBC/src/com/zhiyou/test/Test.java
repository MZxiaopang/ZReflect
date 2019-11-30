package com.zhiyou.test;

import java.util.List;

import com.zhiyou.emp;
import com.zhiyou.util.MyUtil;

public class Test {
	public static void main(String[] args) {
		List<emp> list = MyUtil.Jdbc_DQL("select *from emp", emp.class);
		for (emp emp : list) {
			System.out.println(emp);
		}
	}
}
