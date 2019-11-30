package com.zhiyou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class MainClass {

	public static void main(String[] args) throws Exception {

		// 1：加载驱动（注册驱动）反射驱动 实际上是找到数据库驱动包中心的核心类 第一种注册驱动的方法
		// Class.forName("com.mysql.jdbc.Driver");
		// 第二种注册驱动方法（会造成重复注册驱动） 不推荐使用
		DriverManager.registerDriver(new Driver());
		// 第三种注册驱动方式:可以一次注册多个驱动 但是写起来麻烦
		// System.setProperty("jdbc:drivers", "com.mysql.jdbc.Driver");
		// 2： 获得数据库连接连接本机的mysql (jdbc:mysql:///zalldatatext)
		// 如果不是连接本机的mysql（jdbc:mysql:192.168.72.41:3306///zalldatatext）
		// 如果数据库版本是8.0以上 连接url后面需要跟上时区:serverTimezone=GMT%2B8
		// 8.0以上的连接方式
		// Connection
		// conn=DriverManager.getConnection("jdbc:mysql:localhost///jin?serverTimezone=GMT%2B8&useSSL=false","root",
		// "123456");
		Connection con = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		// 增加数据
		String sql = "insert into Dept values(50,'开发部','郑州');";
		// 修改数据
		String sql1 = "update dept set LOC='北京' where deption=50;";
		// 删除数据
		String sql2 = "delete from dept where deption=50";
		// 查找数据
		String sql3 = "select * from dept";
		// 3.创建statement 对象 用于向数据库发送数据
		Statement statement = con.createStatement();
		// 4.执行sql 接收返回结果信息
		boolean b = statement.execute(sql1);
		// 5.关闭流与连接
		statement.close();
		con.close();
		System.out.println(b);
//		List<emp> arr = Myselect1();
//
//		for (emp dept : arr) {
//			System.out.println(dept);
//		}
	}

	public static List Myselect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		Statement statement = conn.createStatement();
		String sql = "select * from dept";
		ResultSet set = statement.executeQuery(sql);
		ArrayList<dept> list = new ArrayList<dept>();

		set.next();
		while (set.next()) {
			dept d = new dept();
			d.setDeptno(set.getInt("deption"));
			d.setDname(set.getString("dname"));
			d.setLoc(set.getString("loc"));
			list.add(d);
		}
		statement.close();
		conn.close();
		return list;
	}

	public static List Myselect1() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///zalldatatext", "root", "123456");
		Statement statement = conn.createStatement();
		String sql = "select * from emp";
		ResultSet set = statement.executeQuery(sql);
		ArrayList<emp> list = new ArrayList<emp>();
		while (set.next()) {
			emp e = new emp();
			e.setDEPTNO(set.getInt("empno"));
			e.setENAME(set.getString("ename"));
			e.setJOB(set.getString("job"));
			e.setMGR(set.getInt("mgr"));
			e.setHIREDATE(set.getDate("hiredate"));
			e.setSAL(set.getInt("sal"));
			e.setCOMM(set.getInt("comm"));
			e.setDEPTNO(set.getInt("deptno"));
			list.add(e);
		}
		return list;
	}

}
