package com.zhiyou.thing;

import java.sql.Connection;
import java.sql.DriverManager;

public class Shiwu {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");

		try {
			// 设置是否自动提交事物 默认为true 自动提交
			con.setAutoCommit(false);
			String sql1 = "update user1 set age=age-500 where id = 1";
			con.prepareStatement(sql1).execute();
			// System.out.println(85 / 0);// 模拟中途停电
			String sql2 = "update user1 set age=age+500 where id = 2";
			con.prepareStatement(sql2).execute();
			con.commit();
		} catch (Exception e) {
			// 事物的回滚，让数据库返回到事物开始前的状态
			con.rollback();

		} finally {
			con.close();
		}

	}
}
