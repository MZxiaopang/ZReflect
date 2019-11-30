package com.zhiyou;

import java.util.Random;

public class RandomNumber {
	public static String RandomNum() {
		Random random = new Random();
		StringBuilder s = new StringBuilder();
		int j = -1;
		for (int i = 0; i < 6; i++) {
			do {

				j = random.nextInt(123);
				if (j > 0 && j <= 9) {
					s.append(j);
					break;
				} else if (j >= 65 && j <= 90) {
					char num = (char) j;
					s.append(num);
					break;
				} else if (j >= 97 && j <= 122) {
					char num = (char) j;
					s.append(num);
					break;
				}
			} while (true);

		}

		return s.toString();
	}

	public static void main(String[] args) {
		System.out.println(RandomNumber.RandomNum());
	}
}
