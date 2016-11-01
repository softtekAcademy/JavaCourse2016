package com.softtek.java.academy.basics.interfaces.impl.exec;

import java.util.Arrays;

import com.softtek.java.academy.basics.interfaces.impl.Person;
import com.softtek.java.academy.basics.interfaces.impl.PersonEmailComparator;

public class ComparatorExampleMain {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final Person p1 = new Person(34);
		p1.setEmail("fulanito@softtek.com");
		final Person p2 = new Person(45);
		p2.setEmail("margarito@softtek.com");
		final Person p3 = new Person(45);
		p3.setEmail("aaaaa@softtek.com");

//		final Person[] pa = { p1, p3, p2 };
		Person[] pa = new Person[3];
		pa[0] = p1;
		pa[1] = p3;
		pa[2] = p2;

		System.out.println("Before sort:");
		for (Person p : pa) {
			System.out.println(p);
		}

		System.out.println("After sort:");
		
		Arrays.sort(pa, new PersonEmailComparator());
		
		for (Person p : pa) {
			System.out.println(p);
		}

	}

}
