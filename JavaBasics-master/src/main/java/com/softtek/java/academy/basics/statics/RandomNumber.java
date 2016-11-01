package com.softtek.java.academy.basics.statics;

import java.util.Random;


public class RandomNumber {

	/**
	 * @param args
	 */
	public static int getRandomNum() {

		Random r = new Random();
		int n = r.nextInt(101);
		
		return n;
	}

}
