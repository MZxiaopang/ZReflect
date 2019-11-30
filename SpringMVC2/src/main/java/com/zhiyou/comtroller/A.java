package com.zhiyou.comtroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class A {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Administrator\\Desktop\\风景2.jpg");
		File file2 = new File("d:\\123.exe");
		InputStream in = new FileInputStream(file);
		OutputStream out = new FileOutputStream(file2);

		int number = 0;
		byte[] data = new byte[1024];
		while ((number = in.read(data)) != -1) {
			out.write(data, 0, number);
		}
		out.close();
		in.close();
	}
}
