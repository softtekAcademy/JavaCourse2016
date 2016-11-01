package com.softtek.java.academy.basics.operators;

import java.util.Scanner;

public class LogicalOperators {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final int n = 100;
		final Scanner s = new Scanner(System.in);

		System.out.print("Type a number: ");
		final int x = s.nextInt();

		System.out.print("Type a number: ");
		final int y = s.nextInt();

		final Calculator c = new Calculator();

		System.out.println(c.getSum(y, y) <= n);

		System.out.println(c.getRest(y, y) < n);

		System.out.println(c.getMult(y, y) > n);

		System.out.println(c.getDiv(y, y) == n);

		System.out.println(c.getMod(y, y) != n);

		System.out.println(c.isPositive(y));

		System.out.println(c.isPositive(y) || c.isPositive(x));

	}

}
