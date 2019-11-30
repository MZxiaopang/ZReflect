package com.zhiyou.test;

import java.util.List;

import com.zhiyou.dao.impl.EmpImpl;
import com.zhiyou.model.emp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpImpl e = new EmpImpl();
		emp eMP = new emp();
		eMP.setEMPNO(88);
		eMP.setENAME("张三");
		e.add(eMP);
		e.update(eMP);
		e.delete(eMP);
		List<emp> list = e.selectAll();
		for (emp emp2 : list) {
			System.out.println(emp2);
		}
	}

}
