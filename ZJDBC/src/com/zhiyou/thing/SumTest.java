package com.zhiyou.thing;

import java.sql.Connection;
import java.sql.DriverManager;

public class SumTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		conn.setAutoCommit(false);
		String sql1 = "update user1 set age=age-1000 where id=1";
		conn.prepareStatement(sql1).execute();
		System.out.println(4 / 0);// 模拟中途停电
		String sql2 = "update user1 set age=age+1000 where id=2";
		conn.prepareStatement(sql2).execute();
		conn.commit();
		conn.close();
	}

}
