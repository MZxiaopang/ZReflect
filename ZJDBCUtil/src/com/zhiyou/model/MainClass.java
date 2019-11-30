package com.zhiyou.model;

import java.util.List;

import com.zhiyou.util.JDBCUtil;

public class MainClass {

	public static void main(String[] args) {
		List<emp> list = JDBCUtil.dbDQL("select * from emp", emp.class);
		for (emp emp2 : list) {
			System.out.println(emp2);
		}
		System.out.println("*****************************************");
		List<dept> dept1 = JDBCUtil.dbDQL("select *from dept", dept.class);
		for (dept dep : dept1) {
			System.out.println(dep);
		}
		System.out.println("*****************************************");
		JDBCUtil.dbDML("insert into emp(EMPNO,ename) values(?,?)", 67, "加上卡号是");
		System.out.println("*****************************************");
		JDBCUtil.dbDML("update emp set ename=? where empno=?", "开了家", 67);
		System.out.println("*****************************************");
		JDBCUtil.dbDML("delete from emp where ename=?", "开了家");

	}
}
