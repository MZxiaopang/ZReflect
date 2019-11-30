package com.zhiyou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class user {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入账号:");
		String username = sc.next();
		System.out.println("请输入密码:");
		String password = sc.next();
		Connection con = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		String sql = "select * from user1 where user=? and password=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet set = statement.executeQuery();
		if (set.next()) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
		set.close();
		statement.close();
		con.close();
		delete();

	}

	// 增加用户数据
	public static void add() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入用户账号：");
		String name = sc.next();
		System.out.print("\n请输入登录密码");
		String password = sc.next();
		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		String sql = "insert into user1 values(?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, password);
		statement.execute();
		statement.close();
		conn.close();
	}

	// 删除用户数据
	public static void delete() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("输入要删除的账号");
		String name = sc.next();
		System.out.println("输入要删除的密码");
		String password = sc.next();
		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		PreparedStatement statement = conn.prepareStatement("delete from user1 where user =? and password=?");
		statement.setString(1, name);
		statement.setString(2, password);
		statement.execute();
		statement.close();
		conn.close();

	}

	// 更新用户数据
	public static void update() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入要修改的账户:");
		String name = sc.next();
		System.out.println("输入要修改的密码:");
		String password = sc.next();
		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		String sql = "update user1 set password=? where user=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(2, name);
		statement.setString(1, password);
		statement.execute();
		statement.close();
		conn.close();
	}

	// 打印用户数据
	public static void find() throws Exception {
//		Scanner sc =new Scanner(System.in);
//		System.out.println();
		ArrayList list = new ArrayList();

		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		String sql = "select *from user1";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet set = statement.executeQuery();
		while (set.next()) {
			Account account = new Account();
			account.setName(set.getString(1));
			account.setPassword(set.getString(2));
			list.add(account);
		}
		for (Object object : list) {
			System.out.println(object);
		}

		set.close();
		statement.close();
		conn.close();
	}

}
