package com.zhiyou.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyUtil {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "123456";
	private static final String DATABASE_NAME = "zalldatatext";
	private static final String URL = "jdbc:mysql:///" + DATABASE_NAME;
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void Jdbc_DML(String sql, Object... objects) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps, con);
		}
	}

	public static <E> List<E> Jdbc_DQL(String sql, Class class1, Object... objects) {

		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet set = null;
		List<E> list = new ArrayList<E>();
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}

			ResultSetMetaData data = ps.getMetaData();
			String[] names = new String[data.getColumnCount()];

			for (int i = 0; i < names.length; i++) {
				String name = data.getColumnLabel(i + 1);
				names[i] = name;
			}
			set = ps.executeQuery();
			while (set.next()) {
				E o = (E) class1.newInstance();
				for (String string : names) {
					Object value = set.getObject(string);

					Field field = class1.getDeclaredField(string);

					field.setAccessible(true);
					field.set(o, value);
				}
				list.add(o);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps, conn, set);
		}

		return list;

	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet set) {
		try {
			set.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps, Connection con) {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps, Connection con, ResultSet set) {
		try {
			ps.close();
			set.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
