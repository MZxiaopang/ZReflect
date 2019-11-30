package com.zhiyou1.copy;

public class Test {

	public static void main(String[] args) {
		new T().start();
		new T().start();
		new T().start();
		new T().start();
		new T().start();
	}
}

class T extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Singleton5.getSingleton5());
		}
	}
}