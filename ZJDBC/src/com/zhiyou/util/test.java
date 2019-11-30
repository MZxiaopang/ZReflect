package com.zhiyou.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class test {

	public static void main(String[] args) throws Exception {

		System.out.println(Math.round(11.5));
		System.out.println(Math.round(-11.5));
		System.out.println(Math.random());
		Connection con = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		// 设置隔离级别(读已提交)防止脏读,看见不可重复读
		con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		// 设置隔离级别为(可重复读),来防止不可重复读
//		con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		con.setAutoCommit(false);
//		con.prepareStatement("insert into user1(name,id) values('王家啊',29)").execute();
		ResultSet resultSet = con.prepareStatement("select name from user1").executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString("name"));
		}
		System.out.println("****************************************************************************");

		Connection con2 = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		// 设置隔离级别(读已提交)防止脏读,看见不可重复读
		con2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		// 设置隔离级别为(可重复读),来防止不可重复读
//		con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		con2.setAutoCommit(false);

		con2.prepareStatement("update user1 set name='赵六666'  where name='赵六'").execute();

		con2.commit();
		con2.close();

		ResultSet resultSet2 = con.prepareStatement("select name from user1").executeQuery();
		while (resultSet2.next()) {
			System.out.println(resultSet2.getString("name"));
		}

		con.commit();
		resultSet.close();
		resultSet2.close();
		con.close();

	}

}
