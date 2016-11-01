package com.softtek.java.academy.basics.interfaces.impl.exec;

import com.softtek.java.academy.basics.interfaces.impl.Person;


public class StringCompareToExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "String 1 ";
		String s2 = "sTRING 1";
		
		System.out.println(s1.compareTo(s2));
		
		Person p1 = new Person(45);
		Person p2 = new Person(30);
		
		System.out.println(p1.compareTo(p2));
		System.out.println(p2.compareTo(p1));

	}

}
