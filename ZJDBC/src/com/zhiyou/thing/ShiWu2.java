package com.zhiyou.thing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ShiWu2 {

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");

		// 设置事物的隔离级别 读未提交 看见脏读
		// con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		// 设置事物的隔离级别 读已提交 防止脏读 看见不可重复读
		// con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		// 设置事物的隔离级别 (可重复读) 来防止不可重复读
		// con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

		con.setAutoCommit(false);
//		con2.prepareStatement("update user1 set name='赵六222' where id =1").execute();

//		con.prepareStatement("insert into user1(name,id)values('郑八',23)").execute();

//		ResultSet set = con.prepareStatement("select name from user1").executeQuery();
//		while (set.next()) {
//			System.out.println(set.getString("name"));
//		}

/////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("*********************************************");

		Connection con2 = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");

		// 设置事物的隔离级别 读未提交 看见脏读
		// con2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		// 设置事物的隔离级别 读已提交 防止脏读 看见不可重复读
		// con2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		// 设置事物的隔离级别 (可重复读) 来防止不可重复读
		// con2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

		con2.setAutoCommit(false);

//		ResultSet set = con2.prepareStatement("select name from user1").executeQuery();
//		while (set.next()) {
//			System.out.println(set.getString("name"));
//		}
//		con2.prepareStatement("update user1 set name='赵六222' where id =1").execute();

		ResultSet set2 = con.prepareStatement("select name from user1").executeQuery();
		while (set2.next()) {
			System.out.println(set2.getString("name"));
		}

//		set.close();
		set2.close();
		con2.commit();
		con2.close();

		con.commit();

		con.close();
	}
}
