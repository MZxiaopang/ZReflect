package com.zhiyou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入账号:");
		String usernameString = scanner.next();
		System.out.println("请输入密码:");
		String passwordString = scanner.next();
		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		String sql = "select * from dept";
		// Statement statement = conn.createStatement();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, usernameString);
		statement.setString(2, usernameString);
		ResultSet set = statement.executeQuery();

	}

}
