package com.softtek.java.academy.basics.operators;

public class IncrementExample {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int x = 5;

		System.out.println("value of 'x': " + x++);
		System.out.println("value of 'x': " + ++x);

		System.out.println("value of 'x': " + --x);
		System.out.println("value of 'x': " + x--);

		System.out.println(x);
	}

}
