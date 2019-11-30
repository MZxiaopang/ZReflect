package com.zhiyou.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySession implements HttpSessionListener {

	private static int count = 0;// 代表在线总人数

	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
	}

	public static void getCount() {
		System.out.println("当前在线总人数:" + count);

	}

}
