package com.softtek.java.academy.basics.strings;

import java.util.Scanner;

public class StringExamples {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Type something: ");
		
		String word = s.nextLine();
		Vowels v = new Vowels();
		
		
		
		System.out.println(word.toCharArray());

	}

}
