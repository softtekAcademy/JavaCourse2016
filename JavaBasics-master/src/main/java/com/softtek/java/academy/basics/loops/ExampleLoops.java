package com.softtek.java.academy.basics.loops;

import java.util.Scanner;

public class ExampleLoops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.print("Type something: ");

		String value = s.nextLine();

		char[] carray = value.toCharArray();

		System.out.println("Vertical letters:");


		for (int i = 0; i < carray.length; i++) {
			System.out.println(carray[i]);
		}

		//foreach
		for (char caracter : carray) {
			System.out.println(caracter);
		}

	}

}
